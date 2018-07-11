package com.johlcar.essential531;

import com.johlcar.essential531.data.DataSourceInterface;
import com.johlcar.essential531.data.ListItem;
import com.johlcar.essential531.logic.Controller;
import com.johlcar.essential531.view.ViewInterface;

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
     * Test Double:
     *  Specifically a "Mock"
     */
    @Mock
    DataSourceInterface dataSource;

    @Mock
    ViewInterface view;

    Controller controller;

    private static final ListItem testItem = new ListItem(
            "6:30AM 06/01/2017",
            "Check out content like Fragmented Podcast to expose yourself to the knowledge, ideas, " +
                    "and opinions of experts in your field",
            R.color.RED

    );

    @Before
    public void setUpTest() {
        MockitoAnnotations.initMocks(this);
        controller = new Controller(view, dataSource);
    };

    @Test
    public void onGetListDataSuccessful() {
        // Set up any data we need for the test
        ArrayList<ListItem> listOfData = new ArrayList<>();
        listOfData.add(testItem);

        // Set up our Mocks to return the data we want
        Mockito.when(dataSource.getListOfData())
                .thenReturn(listOfData);

        // Call the method unit we are testing
        controller.getListFromDataSource();

        // Check how the tested class responds to the data it receives
        // or test its behavior
        Mockito.verify(view).setUpAdapterAndView(listOfData);
    }

    @Test
    public void onListItemClicked() {
        controller.onListItemClick(testItem);

        Mockito.verify(view).startDetailActivity(
                testItem.getDateAndTime(),
                testItem.getMessage(),
                testItem.getColorResource());
    }
}