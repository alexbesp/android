package com.example.alexanderbespalov.mvpedu.presentation.view.ex3;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface ShowTimerAndMsgAlertDialogView extends MvpView {

    void setTimer(int seconds);
    void showTimer();
    void hideTimer();
    void showMessage(int message);
    void hideMessage();
}
