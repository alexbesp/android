package com.alexanderbespalov.musiceng.ui.activity.main;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.ToggleButton;

import com.alexanderbespalov.musiceng.presentation.view.main.MainView;
import com.alexanderbespalov.musiceng.presentation.presenter.main.MainPresenter;

import com.alexanderbespalov.musiceng.ui.adapter.main.LyricsAdapter;
import com.arellomobile.mvp.MvpActivity;

import com.example.alexanderbespalov.musiceng.R;

import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends MvpActivity implements MainView {
    public static final String TAG = "MainActivity";
    public static MainActivity mn;
    @InjectPresenter
    MainPresenter mMainPresenter;

    @BindView(R.id.rec_root) RecyclerView recyclerView;
    @BindView(R.id.btn_play) ToggleButton btnPlay;
    @BindView(R.id.btn_seek_back) ImageButton btnSeekBack;
    @BindView(R.id.btn_seek_forvard) ImageButton btnSeekForward;
    @BindView(R.id.seekBar) SeekBar seekBar;
    @BindView(R.id.swipe_layout_main) SwipeRefreshLayout swipeRefreshLayout;

    private MediaPlayer mediaPlayer;
    private LyricsAdapter adapter;
    private LinearLayoutManager layoutManager;

    public static Intent getIntent(final Context context) {
        Intent intent = new Intent(context, MainActivity.class);

        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mn = MainActivity.this;
        ButterKnife.bind(this);
        if (savedInstanceState == null) swipeRefreshLayout.setRefreshing(true);
        Log.d(TAG, "onCreate: activity started");

        setUpLayoutManagerAndAdapter();
        setUpMedia();
        setListeners();
        mMainPresenter.loadLyrics();

    }

    private void setUpMedia() {
        mediaPlayer = MediaPlayer.create(this, R.raw.eminem_superman);
        seekBar.setMax(mediaPlayer.getDuration());
    }

    private void setUpLayoutManagerAndAdapter() {
        layoutManager = new LinearLayoutManager(this);
        adapter = new LyricsAdapter(mMainPresenter.getDoc());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, layoutManager.getOrientation());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(adapter);
    }

    private void setListeners() {
        btnPlay.setOnCheckedChangeListener((view, isChecked) -> {
            if (isChecked) {
                mediaPlayer.start();
            } else {
                mediaPlayer.pause();
            }
        });
        btnSeekBack.setOnClickListener(view -> mediaPlayer.seekTo(mediaPlayer.getCurrentPosition() - 5000));
        btnSeekForward.setOnClickListener(view -> mediaPlayer.seekTo(mediaPlayer.getCurrentPosition() + 5000));

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        swipeRefreshLayout.setOnRefreshListener(() -> swipeRefreshLayout.setRefreshing(false));
    }

    @Override
    public void onDataChanged() {
        recyclerView.setAdapter(new LyricsAdapter(mMainPresenter.getDoc()));
        swipeRefreshLayout.setRefreshing(false);
      //  recyclerView.getAdapter().notifyDataSetChanged();
    }
}
