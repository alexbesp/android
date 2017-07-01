package com.example.alexanderbespalov.mvpedu.ui.activity.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.alexanderbespalov.mvpedu.R;
import com.example.alexanderbespalov.mvpedu.models.main.DbManager;
import com.example.alexanderbespalov.mvpedu.models.main.Exercise;
import com.example.alexanderbespalov.mvpedu.presentation.view.main.MainView;
import com.example.alexanderbespalov.mvpedu.presentation.presenter.main.MainPresenter;

import com.arellomobile.mvp.MvpActivity;


import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.alexanderbespalov.mvpedu.ui.adapters.main.ExercisesAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;

public class MainActivity extends MvpActivity implements MainView {
    public static final String TAG = "MainActivity";
    @InjectPresenter
    MainPresenter mMainPresenter;

    @BindView(R.id.recycler_main) RecyclerView mainRecycler;
//    private ExercisesAdapter exercisesAdapter;
    private Realm realm;


    public static Intent getIntent(final Context context) {
        Intent intent = new Intent(context, MainActivity.class);

        return intent;
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        realm = Realm.getDefaultInstance();
        ButterKnife.bind(this);
        mainRecycler.setLayoutManager(new LinearLayoutManager(this));
        //exercisesAdapter = new ExercisesAdapter(DbManager.getAllExercises());
        mainRecycler.setAdapter(new ExercisesAdapter(realm.where(Exercise.class).findAllAsync()));

        Handler handler = new Handler();
        handler.postDelayed(()-> (new DbManager())
                .addExercise("com.example.alexanderbespalov.mvpedu.ui.activity.ex5.FragmentCounterActivity.class",
                             "Exercise5",
                             "Show 2 fragments with independent counters"),
                             3000);

        handler.postDelayed(()-> (new DbManager())
                .addExercise("com.example.alexanderbespalov.mvpedu.ui.activity.ex5.FragmentCounterActivity.class",
                             "Exercise5",
                             "Show 2 fragments with independent counters"),
                             5000);

        handler.postDelayed(()-> (new DbManager())
                .addExercise("com.example.alexanderbespalov.mvpedu.ui.activity.ex5.FragmentCounterActivity.class",
                             "Exercise5",
                             "Show 2 fragments with independent counters"),
                             7000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}
