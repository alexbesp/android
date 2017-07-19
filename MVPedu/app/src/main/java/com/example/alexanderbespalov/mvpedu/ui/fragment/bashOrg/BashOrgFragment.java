package com.example.alexanderbespalov.mvpedu.ui.fragment.bashOrg;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.example.alexanderbespalov.mvpedu.R;
import com.example.alexanderbespalov.mvpedu.presentation.presenter.bashOrg.BashOrgFragmentPresenter;
import com.example.alexanderbespalov.mvpedu.presentation.view.bashOrg.BashOrgFragmentView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.alexanderbespalov.mvpedu.ui.adapters.main.bashOrg.BashNewRecyclerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.view.View.GONE;

public class BashOrgFragment extends MvpAppCompatFragment implements BashOrgFragmentView {
    public static final String TAG = "BashOrgFragment";
    public int num;

    @InjectPresenter
    BashOrgFragmentPresenter bashOrgFragmentPresenter;
    private LinearLayoutManager layoutManager;

    public static BashOrgFragment newInstance(int num) {
        BashOrgFragment fragment = new BashOrgFragment();
        Bundle args = new Bundle();
        args.putInt("num", num);
        fragment.setArguments(args);

        return fragment;
    }

    @BindView(R.id.swipe_refresh_layout_bash_new) SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.recycler_bash_new) RecyclerView recyclerBashOrg;
    @BindView(R.id.bashitem_progress_bar) ProgressBar progressBar;
    @BindView(R.id.tv_loading_error) TextView tvError;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {

        num = getArguments().getInt("num");

        View view = inflater.inflate(R.layout.fragment_bash_org, container, false);
        ButterKnife.bind(this, view);
        if (savedInstanceState == null) showRefreshing();

        layoutManager = new LinearLayoutManager(view.getContext());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerBashOrg.getContext(), layoutManager.getOrientation());
        BashNewRecyclerAdapter adapter = new BashNewRecyclerAdapter(bashOrgFragmentPresenter.getPosts());

        recyclerBashOrg.setLayoutManager(layoutManager);
        recyclerBashOrg.addItemDecoration(dividerItemDecoration);
        recyclerBashOrg.setAdapter(adapter);

        setUpListeners();

        bashOrgFragmentPresenter.loadPosts(num);



        return view;
    }

    private void setUpListeners() {
        swipeRefreshLayout.setOnRefreshListener(() -> bashOrgFragmentPresenter.onRefresh(num));

        recyclerBashOrg.addOnScrollListener(new EndlessRecyclerOnScrollListener(layoutManager) {
            @Override
            public void onLoadMore() {
                progressBar.setVisibility(View.VISIBLE);
                bashOrgFragmentPresenter.loadMore(num);
            }
        });

        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        this.getContext().registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (layoutManager.getItemCount() == 0) bashOrgFragmentPresenter.loadPosts(num);
            }
        }, filter);
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void showRefreshing() {
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideRefreshing() {
        swipeRefreshLayout.setRefreshing(false);
    }

    public void onDataChanged() {
        tvError.setVisibility(GONE);
        recyclerBashOrg.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void hideUpdating() {
        progressBar.setVisibility(GONE);
    }

    @Override
    public void onConnectionFailure() {
        tvError.setVisibility(View.VISIBLE);
    }

    @Override
    public void onDataUpdateFailure() {
        Toast.makeText(this.getContext(), "Отсутствует подключение к сети", Toast.LENGTH_SHORT).show();
    }


}
