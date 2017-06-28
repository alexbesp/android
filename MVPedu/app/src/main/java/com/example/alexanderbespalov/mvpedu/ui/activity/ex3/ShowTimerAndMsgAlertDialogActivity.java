package com.example.alexanderbespalov.mvpedu.ui.activity.ex3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.TextView;

import com.example.alexanderbespalov.mvpedu.R;
import com.example.alexanderbespalov.mvpedu.presentation.view.ex3.ShowTimerAndMsgAlertDialogView;
import com.example.alexanderbespalov.mvpedu.presentation.presenter.ex3.ShowTimerAndMsgAlertDialogPresenter;

import com.arellomobile.mvp.MvpActivity;


import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowTimerAndMsgAlertDialogActivity extends MvpActivity implements ShowTimerAndMsgAlertDialogView {
    public static final String TAG = "ShowTimerAndMsgAlertDialogActivity";
    @InjectPresenter
    ShowTimerAndMsgAlertDialogPresenter mShowTimerAndMsgAlertDialogPresenter;

    public static Intent getIntent(final Context context) {
        Intent intent = new Intent(context, ShowTimerAndMsgAlertDialogActivity.class);

        return intent;
    }

    private AlertDialog mMessageDialog;
    @BindView(R.id.tv_timer) TextView timerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_timer_and_msg_alert_dialog);
        ButterKnife.bind(this);
    }

    @Override
    public void setTimer(int seconds) {
        timerTextView.setText("" + seconds);
    }

    @Override
    public void showTimer() {
        timerTextView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideTimer() {
        timerTextView.setVisibility(View.GONE);

    }

    @Override
    public void showMessage(int message) {
        mMessageDialog = new AlertDialog.Builder(this)
                .setTitle(R.string.app_name).setMessage(message)
                .setPositiveButton(android.R.string.ok, null)
                .setOnDismissListener(dialogInterface -> mShowTimerAndMsgAlertDialogPresenter.onDismissMessage())
                .show();
    }

    @Override
    public void hideMessage() {
        if (mMessageDialog != null) {
            mMessageDialog.dismiss();
        }
    }
}
