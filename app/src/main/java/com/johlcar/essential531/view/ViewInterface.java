package com.johlcar.essential531.view;

import com.johlcar.essential531.data.ListItem;

import java.util.List;

public interface ViewInterface {

    void startDetailActivity(String dateAndTime, String message, int colorResource);
    void setUpAdapterAndView(List<ListItem> listOfData);

}
