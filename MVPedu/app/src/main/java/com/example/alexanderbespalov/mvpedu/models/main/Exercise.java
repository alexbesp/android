package com.example.alexanderbespalov.mvpedu.models.main;

import android.app.Activity;

/**
 * Created by alexander.bespalov on 22.06.2017.
 */

public class Exercise {
    private Class cls;
    private String name;
    private String description;

    public Class getCls() {
        return cls;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Exercise(Class cls, String name, String description) {
        this.cls = cls;
        this.name = name;
        this.description = description;
    }
}
