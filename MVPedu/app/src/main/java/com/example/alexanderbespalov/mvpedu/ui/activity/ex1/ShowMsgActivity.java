package com.example.alexanderbespalov.mvpedu.ui.activity.ex1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.alexanderbespalov.mvpedu.R;
import com.example.alexanderbespalov.mvpedu.presentation.view.ex1.ShowMsgView;
import com.example.alexanderbespalov.mvpedu.presentation.presenter.ex1.ShowMsgPresenter;

import com.arellomobile.mvp.MvpActivity;


import com.arellomobile.mvp.presenter.InjectPresenter;

public class ShowMsgActivity extends MvpActivity implements ShowMsgView {
    public static final String TAG = "ShowMsgActivity";
    @InjectPresenter
    ShowMsgPresenter mShowMsgPresenter;

    public static Intent getIntent(final Context context) {
        Intent intent = new Intent(context, ShowMsgActivity.class);

        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_msg);
    }

    // create view in runtime
    @Override
    public void showMessage(int message) {
        TextView messageTextView = new TextView(this);
        messageTextView.setText(message);
        messageTextView.setTextSize(40);
        messageTextView.setGravity(Gravity.CENTER_HORIZONTAL);
        ((ViewGroup) findViewById(R.id.activity_show_msg)).addView(messageTextView);
    }
}
