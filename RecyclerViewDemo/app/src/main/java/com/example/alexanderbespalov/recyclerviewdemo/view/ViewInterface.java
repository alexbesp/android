package com.example.alexanderbespalov.recyclerviewdemo.view;

import com.example.alexanderbespalov.recyclerviewdemo.data.ListItem;

import java.util.List;

/**
 * Created by alexander.bespalov on 19.06.2017.
 */

public interface ViewInterface {

    void startDetailActivity(String dateAndTime, String message, int colorResourse);
    void setUpAdapterAndView(List<ListItem> listOfData);

}
