package com.example.alexanderbespalov.mvpedu.presentation.presenter.main;


import android.content.Context;
import android.content.Intent;

import com.example.alexanderbespalov.mvpedu.model.main.Exercise;
import com.example.alexanderbespalov.mvpedu.presentation.view.main.MainView;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {
    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();

    }

    public void onExerciseClicked(Exercise exercise, Context context) {
        Intent intent = new Intent(String.valueOf(exercise.getClass()));
    }
}
