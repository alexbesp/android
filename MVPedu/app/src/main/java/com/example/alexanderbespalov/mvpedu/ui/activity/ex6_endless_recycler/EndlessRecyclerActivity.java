package com.example.alexanderbespalov.mvpedu.ui.activity.ex6_endless_recycler;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.alexanderbespalov.mvpedu.R;
import com.example.alexanderbespalov.mvpedu.ui.fragment.bashOrg.EndlessRecyclerOnScrollListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by alexander.bespalov on 07.07.2017.
 */

public class EndlessRecyclerActivity extends AppCompatActivity {
    private List<String> mStringList;
    private int mLoadedItems = 0;
    private SampleAdapter mSampleAdapter;
    @BindView(R.id.recycler_view_endless) RecyclerView recyclerView;
    @BindView(R.id.item_progress_bar) ProgressBar itemProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endless_recycler);
        ButterKnife.bind(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mStringList = new ArrayList<>();
        mSampleAdapter = new SampleAdapter(mStringList);
        recyclerView.setAdapter(mSampleAdapter);
        addDataToList();

        recyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore() {
                addDataToList();
            }
        });
    }

    private void addDataToList() {
        itemProgressBar.setVisibility(View.VISIBLE);
        new Handler().postDelayed(() -> {
            for (int i = 0; i <= 30; i++) {
                mStringList.add("SampleText : " + mLoadedItems);
                mLoadedItems++;
            }
            mSampleAdapter.notifyDataSetChanged();
            itemProgressBar.setVisibility(View.GONE);
        }, 1500);

    }
}