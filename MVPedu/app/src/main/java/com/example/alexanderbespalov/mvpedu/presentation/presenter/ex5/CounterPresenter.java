package com.example.alexanderbespalov.mvpedu.presentation.presenter.ex5;


import com.example.alexanderbespalov.mvpedu.presentation.view.ex5.CounterView;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

@InjectViewState
public class CounterPresenter extends MvpPresenter<CounterView> {
    private int count;

    public CounterPresenter() {
        getViewState().showCount(count);
    }

    public void onPlusClick() {
        count++;
        getViewState().showCount(count);
    }
}
