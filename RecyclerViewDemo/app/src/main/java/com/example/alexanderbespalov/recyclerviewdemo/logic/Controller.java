package com.example.alexanderbespalov.recyclerviewdemo.logic;

import com.example.alexanderbespalov.recyclerviewdemo.data.DataSourceInterface;
import com.example.alexanderbespalov.recyclerviewdemo.data.ListItem;
import com.example.alexanderbespalov.recyclerviewdemo.view.ViewInterface;

/**
 * Created by alexander.bespalov on 19.06.2017.
 */

public class Controller {

    private ViewInterface view;
    private DataSourceInterface dataSource;

    public Controller(ViewInterface view, DataSourceInterface dataSource) {
        this.view = view;
        this.dataSource = dataSource;

        getListFromDataSource();
    }

    public void getListFromDataSource() {
        view.setUpAdapterAndView(
                dataSource.getListOfData()
        );
    }

    public void onListItemClicked(ListItem testItem) {
        view.startDetailActivity(
                testItem.getDateAndTime(),
                testItem.getMessage(),
                testItem.getColorResourse()
        );
    }
}
