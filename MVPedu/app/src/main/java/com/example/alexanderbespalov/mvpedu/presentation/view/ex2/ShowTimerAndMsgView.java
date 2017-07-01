package com.example.alexanderbespalov.mvpedu.presentation.view.ex2;

import com.arellomobile.mvp.MvpView;

public interface ShowTimerAndMsgView extends MvpView {
    void showMessage(int message);
    void showTimer();
    void hideTimer();
    void setTimer(int seconds);
}
