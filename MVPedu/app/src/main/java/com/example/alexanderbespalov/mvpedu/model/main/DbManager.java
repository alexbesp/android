package com.example.alexanderbespalov.mvpedu.model.main;

import io.realm.Realm;

/**
 * Created by alexander.bespalov on 28.06.2017.
 */

public class DbManager {
    private Realm realm = Realm.getDefaultInstance();
  //  private DbManager() {}



    public void fillDB(){
        realm.executeTransaction(realm1 -> realm1.deleteAll());
        addExercise("com.example.alexanderbespalov.mvpedu.ui.activity.bashOrg.BashOrgActivity", "Bash org reader", "Get access to latest gags");
        addExercise("com.example.alexanderbespalov.mvpedu.ui.activity.ex1.ShowMsgActivity", "Exercise1", "Show message on start after 1 second");
        addExercise("com.example.alexanderbespalov.mvpedu.ui.activity.ex2.ShowTimerAndMsgActivity", "Exercise2", "Show message on start after 5 seconds timer");
        addExercise("com.example.alexanderbespalov.mvpedu.ui.activity.ex3.ShowTimerAndMsgAlertDialogActivity", "Exercise3", "Show message on start after 5 seconds timer in Alert Dialog");
        addExercise("com.example.alexanderbespalov.mvpedu.ui.activity.ex5.FragmentCounterActivity.class", "Exercise5", "Show 2 fragments with independent counters");
        addExercise("com.example.alexanderbespalov.mvpedu.ui.activity.ex6_endless_recycler.EndlessRecyclerActivity", "Endless Recycler", "Try it");
        realm.close();
    }

    public void addExercise(String className, String name, String description){
        realm.executeTransactionAsync(bgRealm -> {
            Exercise exercise = bgRealm.createObject(Exercise.class);
            exercise.setClassName(className);
            exercise.setName(name);
            exercise.setDescription(description);
        });
    }

//    public static RealmResults<Exercise> getAllExercises() {
//        RealmResults<Exercise> exercises = Realm.getDefaultInstance().where(Exercise.class).findAll();
//        return exercises;
//    }
}
