package com.example.alexanderbespalov.mvpedu.presentation.view.ex5;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface CounterView extends MvpView {
//    @StateStrategyType(AddToEndSingleStrategy.class);
    void showCount(int count);
}
