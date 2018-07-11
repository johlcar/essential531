package com.johlcar.essential531.logic;

import android.view.View;

import com.johlcar.essential531.data.DataSourceInterface;
import com.johlcar.essential531.data.ListItem;
import com.johlcar.essential531.view.ViewInterface;

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

   public void onListItemClick(ListItem testItem) {
      view.startDetailActivity(
              testItem.getDateAndTime(),
              testItem.getMessage(),
              testItem.getColorResource()
      );
   }
}
