package com.example.alexanderbespalov.mvpedu.presentation.presenter.bashOrg;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.example.alexanderbespalov.mvpedu.model.bashOrg.PostModel;
import com.example.alexanderbespalov.mvpedu.presentation.view.bashOrg.BashOrgFragmentView;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.alexanderbespalov.mvpedu.ui.activity.main.MyApp;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@InjectViewState
public class BashOrgFragmentPresenter extends MvpPresenter<BashOrgFragmentView> {
    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();

    }

    private List<PostModel> posts = new ArrayList<>();
    private String resourceName;

    public void loadPosts(int num) {
        if (num == 1) resourceName = "bash";
        if (num == 2) resourceName = "abyss";
        MyApp.getApi().getData(resourceName, 30).enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                posts.clear();
                posts.addAll(response.body());
                getViewState().onDataChanged();
                getViewState().hideRefreshing();
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                getViewState().onConnectionFailure();
                Log.e("blyat",t.getMessage() + t.getCause(),t);
                getViewState().hideRefreshing();

            }
        });

    }

    public void loadMore(int num) {
        if (!isConnected(MyApp.getContext())) {
            getViewState().onDataUpdateFailure();
            getViewState().hideUpdating();
            return;
        }

        if (num == 1) resourceName = "bash";
        if (num == 2) resourceName = "abyss";
        MyApp.getApi().getData(resourceName, 100).enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                posts.addAll(response.body());
                getViewState().onDataChanged();
                getViewState().hideRefreshing();
                getViewState().hideUpdating();
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                Log.e("blyat",t.getMessage() + t.getCause(),t);
                getViewState().hideRefreshing();
                getViewState().hideUpdating();
            }
        });
    }

    public boolean isConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            NetworkInfo mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if((mobile != null && mobile.isConnectedOrConnecting()) || (wifi != null && wifi.isConnectedOrConnecting())) {
                return true;
            } else
                return false;
        } else
        return false;
    }

    public List<PostModel> getPosts() {
        return posts;
    }

    public void onRefresh(int num) {
        loadPosts(num);
    }
}
