package com.example.alexanderbespalov.recyclerviewdemo.data;

/**
 * Created by alexander.bespalov on 19.06.2017.
 */

public class ListItem {
    private String dateAndTime;
    private String message;
    private int colorResourse;

    public ListItem(String dateAndTime, String message, int colorResourse) {
        this.dateAndTime = dateAndTime;
        this.message = message;
        this.colorResourse = colorResourse;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getColorResourse() {
        return colorResourse;
    }

    public void setColorResourse(int colorResourse) {
        this.colorResourse = colorResourse;
    }
}
