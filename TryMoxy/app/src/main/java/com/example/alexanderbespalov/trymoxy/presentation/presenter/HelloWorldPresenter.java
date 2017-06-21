package com.example.alexanderbespalov.trymoxy.presentation.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.alexanderbespalov.trymoxy.R;
import com.example.alexanderbespalov.trymoxy.presentation.view.HelloWorldView;

/**
 * Created by alexander.bespalov on 09.06.2017.
 */

@InjectViewState
public class HelloWorldPresenter extends MvpPresenter<HelloWorldView> {
    public HelloWorldPresenter() {
        getViewState().showMessage(R.string.hello_world);
    }
}
