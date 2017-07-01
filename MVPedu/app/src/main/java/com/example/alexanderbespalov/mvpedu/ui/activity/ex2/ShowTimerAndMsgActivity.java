package com.example.alexanderbespalov.mvpedu.ui.activity.ex2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.alexanderbespalov.mvpedu.R;
import com.example.alexanderbespalov.mvpedu.presentation.view.ex2.ShowTimerAndMsgView;
import com.example.alexanderbespalov.mvpedu.presentation.presenter.ex2.ShowTimerAndMsgPresenter;

import com.arellomobile.mvp.MvpActivity;


import com.arellomobile.mvp.presenter.InjectPresenter;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowTimerAndMsgActivity extends MvpActivity implements ShowTimerAndMsgView {
    public static final String TAG = "ShowTimerAndMsgActivity";
    @InjectPresenter
    ShowTimerAndMsgPresenter mShowTimerAndMsgPresenter;

    public static Intent getIntent(final Context context) {
        Intent intent = new Intent(context, ShowTimerAndMsgActivity.class);

        return intent;
    }

    @BindView(R.id.tv_timer) TextView mTimerTextView;
    @BindView(R.id.activity_show_timer_and_msg) ConstraintLayout rootConstraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_timer_and_msg);
        ButterKnife.bind(this);
    }


    @Override
    public void showMessage(int message) {

        TextView messageTextView = new TextView(this);
        messageTextView.setGravity(Gravity.CENTER_VERTICAL);
        messageTextView.setTextSize(35);
        messageTextView.setText(message);
        rootConstraintLayout.addView(messageTextView);

        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(rootConstraintLayout);
        constraintSet.connect(messageTextView.getId(), ConstraintSet.LEFT, rootConstraintLayout.getId(), ConstraintSet.LEFT, 18);
        constraintSet.connect(messageTextView.getId(), ConstraintSet.RIGHT, rootConstraintLayout.getId(), ConstraintSet.RIGHT, 18);
        constraintSet.connect(messageTextView.getId(), ConstraintSet.TOP, rootConstraintLayout.getId(), ConstraintSet.TOP, 18);
        constraintSet.connect(messageTextView.getId(), ConstraintSet.BOTTOM, rootConstraintLayout.getId(), ConstraintSet.BOTTOM, 18);
        constraintSet.applyTo(rootConstraintLayout);

    }

    @Override
    public void showTimer() {
        mTimerTextView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideTimer() {
        mTimerTextView.setVisibility(View.GONE);
    }

    @Override
    public void setTimer(int seconds) {
        mTimerTextView.setText(getString(R.string.timer, seconds));
    }
}
