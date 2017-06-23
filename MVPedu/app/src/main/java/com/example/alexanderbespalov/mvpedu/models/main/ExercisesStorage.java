package com.example.alexanderbespalov.mvpedu.models.main;

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
        exerciseList.add(new Exercise(MainActivity.class, "Exercise1", "My first creation"));

    }

     public static ExercisesStorage getInstance(){
         return ExercisesStorageHolder.INSTANCE;
     }

     public static final class ExercisesStorageHolder {
         private static final ExercisesStorage INSTANCE = new ExercisesStorage();
     }

}
