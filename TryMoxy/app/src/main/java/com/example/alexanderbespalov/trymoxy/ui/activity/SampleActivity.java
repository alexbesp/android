package com.example.alexanderbespalov.trymoxy.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.alexanderbespalov.trymoxy.R;
import com.example.alexanderbespalov.trymoxy.presentation.view.SampleView;
import com.example.alexanderbespalov.trymoxy.presentation.presenter.SamplePresenter;

import com.arellomobile.mvp.MvpActivity;


import com.arellomobile.mvp.presenter.InjectPresenter;

public class SampleActivity extends MvpActivity implements SampleView {
    public static final String TAG = "SampleActivity";
    @InjectPresenter
    SamplePresenter mSamplePresenter;

    public static Intent getIntent(final Context context) {
        Intent intent = new Intent(context, SampleActivity.class);

        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
    }
}
