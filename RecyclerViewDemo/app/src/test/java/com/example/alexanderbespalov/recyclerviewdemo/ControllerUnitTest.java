package com.example.alexanderbespalov.recyclerviewdemo;

import com.example.alexanderbespalov.recyclerviewdemo.data.DataSourceInterface;
import com.example.alexanderbespalov.recyclerviewdemo.data.ListItem;
import com.example.alexanderbespalov.recyclerviewdemo.logic.Controller;
import com.example.alexanderbespalov.recyclerviewdemo.view.ViewInterface;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(MockitoJUnitRunner.class)
public class ControllerUnitTest {

    /**
     * TestDouble:
     * Specifically a "Mock"
     */

    @Mock
    DataSourceInterface dataSource;

    @Mock
    ViewInterface view;

    Controller controller;

    private static final ListItem testItem = new ListItem(
            "6:30AM 06/01/2017",
            "Check out content like Fragmented Podcast to expose yourself",
            R.color.RED
    );

    @Before
    public void setUpTest() {
        MockitoAnnotations.initMocks(this);
        controller = new Controller(view, dataSource);
    }

    @Test
    public void onGetListDataSuccessful() throws Exception {
        //Set up any data we need for the test
        ArrayList<ListItem> listOfData = new ArrayList<>();
        listOfData.add(testItem);

        //Set up our Mocks to return the data we want
        Mockito.when(dataSource.getListOfData()).thenReturn(listOfData);

        //Call the method(Unit) we are testing
        controller.getListFromDataSource();

        //Check how the Tested Class responds to the data it recieves
        //or test it's behaviour
        Mockito.verify(view).setUpAdapterAndView(listOfData);
    }

    @Test
    public void onListItemClicked() {
        controller.onListItemClicked(testItem);

        Mockito.verify(view).startDetailActivity(
                testItem.getDateAndTime(),
                testItem.getMessage(),
                testItem.getColorResourse()
        );
    }
}