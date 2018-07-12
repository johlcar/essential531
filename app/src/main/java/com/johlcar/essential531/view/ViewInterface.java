package com.johlcar.essential531.view;

import com.johlcar.essential531.data.ListItem;

import java.util.List;

public interface ViewInterface {

    void startDetailActivity(int cycleId, String dateAndTime, int squatMax, int benchMax, int pressMax,
                             int deadLiftMax);
    void setUpAdapterAndView(List<ListItem> listOfData);

}
