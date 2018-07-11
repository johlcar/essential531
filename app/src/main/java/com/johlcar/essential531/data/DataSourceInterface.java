package com.johlcar.essential531.data;

import java.util.List;

/**
 * This is a contract between classes that dictates how they can talk to each
 * other without giving implementation details.
 */
public interface DataSourceInterface {

    List<ListItem> getListOfData();

}
