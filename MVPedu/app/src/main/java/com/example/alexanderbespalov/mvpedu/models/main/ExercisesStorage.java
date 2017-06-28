package com.example.alexanderbespalov.mvpedu.models.main;

import com.example.alexanderbespalov.mvpedu.ui.activity.ex1.ShowMsgActivity;
import com.example.alexanderbespalov.mvpedu.ui.activity.ex2.ShowTimerAndMsgActivity;
import com.example.alexanderbespalov.mvpedu.ui.activity.ex3.ShowTimerAndMsgAlertDialogActivity;
import com.example.alexanderbespalov.mvpedu.ui.activity.ex5.FragmentCounterActivity;
import com.example.alexanderbespalov.mvpedu.ui.activity.main.MainActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexander.bespalov on 22.06.2017.
 */

public class ExercisesStorage {

    private final List<Exercise> exerciseList = new ArrayList<>();

    public List<Exercise> getExerciseList() {
        return exerciseList;
    }

    private ExercisesStorage(){
        exerciseList.add(new Exercise(ShowMsgActivity.class, "Exercise1", "Show message on start after 1 second"));
        exerciseList.add(new Exercise(ShowTimerAndMsgActivity.class, "Exercise2", "Show message on start after 5 seconds timer"));
        exerciseList.add(new Exercise(ShowTimerAndMsgAlertDialogActivity.class, "Exercise3", "Show message on start after 5 seconds timer in Alert Dialog"));
        exerciseList.add(new Exercise(FragmentCounterActivity.class, "Exercise5", "Show 2 fragments with independent counters"));
    }

     public static ExercisesStorage getInstance(){
         return ExercisesStorageHolder.INSTANCE;
     }

     public static final class ExercisesStorageHolder {
         private static final ExercisesStorage INSTANCE = new ExercisesStorage();
     }

}
