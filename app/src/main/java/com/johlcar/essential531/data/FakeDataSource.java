package com.johlcar.essential531.data;

import com.johlcar.essential531.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Test Double
 * FakeDataSource model for unit testing
 */

public class FakeDataSource implements DataSourceInterface {

    private static final int sizeOfCollection = 12;

    private final int[] cycleIDs = {
            1,
            2,
            3,
            4
    };

    private final String[] datesAndTimes = {
            "6:30AM 06/01/2017",
            "9:26PM 04/22/2013",
            "2:01PM 12/02/2015",
            "2:43AM 09/7/2018",
    };

    private final int[] squatMaxes = {
            300,
            400,
            200,
            600

    };

    private final int[] benchMaxes = {
            200,
            250,
            300,
            315

    };

    private final int[] pressMaxes = {
            115,
            200,
            185,
            250

    };

    private final int[] deadLiftMaxes = {
            200,
            300,
            400,
            800

    };

    public FakeDataSource(){

    }

    @Override
    public List<ListItem> getListOfData() {
        ArrayList<ListItem> listOfData = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < 12; i++){

            int randOne = random.nextInt(4);

            ListItem listItem = new ListItem(
                    cycleIDs[randOne],
                    datesAndTimes[randOne],
                    squatMaxes[randOne],
                    benchMaxes[randOne],
                    pressMaxes[randOne],
                    deadLiftMaxes[randOne]
            );

            listOfData.add(listItem);
        }

        return listOfData;
    }
}
