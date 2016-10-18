package com.example.alexanderbespalov.activityresultexam.util;

/**
 * Created by alexander.bespalov on 14.10.2016.
 */
public enum Language {

    ENGLISH("Английский"),
    RUSSIAN("Русский"),
    DEUTCH("Немецкий");

    private String language;

    Language(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }
}
