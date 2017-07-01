package com.example.alexanderbespalov.mvpedu.models.main;

import android.app.Activity;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by alexander.bespalov on 22.06.2017.
 */

public class Exercise extends RealmObject {

    private String className;
    private String name;
    private String description;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Exercise(){}

    public static Exercise create(String className, String name, String description) {
        Exercise exercise = new Exercise();
        exercise.className = className;
        exercise.name = name;
        exercise.description = description;
        return exercise;
    }
}
