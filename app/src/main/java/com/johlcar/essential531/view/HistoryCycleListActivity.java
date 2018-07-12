package com.johlcar.essential531.view;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.johlcar.essential531.R;
import com.johlcar.essential531.data.FakeDataSource;
import com.johlcar.essential531.data.ListItem;
import com.johlcar.essential531.logic.Controller;

import java.util.List;

public class HistoryCycleListActivity extends AppCompatActivity implements ViewInterface {

    private static final String EXTRA_CYCLE_ID = "EXTRA_CYCLE_ID";
    private static final String EXTRA_DATE_AND_TIME = "EXTRA_DATE_AND_TIME";
    private static final String EXTRA_SQUAT_MAX = "EXTRA_SQUAT_MAX";
    private static final String EXTRA_BENCH_MAX = "EXTRA_BENCH_MAX";
    private static final String EXTRA_PRESS_MAX = "EXTRA_PRESS_MAX";
    private static final String EXTRA_DEAD_LIFT_MAX = "EXTRA_DEAD_LIFT_MAX ";

    private List<ListItem> listOfData;

    private LayoutInflater layoutInflater;
    private RecyclerView recyclerView;
    private CustomAdapter adapter;

    private Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_cycle_list);

        recyclerView = (RecyclerView) findViewById(R.id.rec_list_activity);
        layoutInflater = getLayoutInflater();

        // Dependency Injection
        controller = new Controller(this, new FakeDataSource());
    }

    @Override
    public void startDetailActivity(int cycleId, String dateAndTime, int squatMax, int benchMax,
                                    int pressMax, int deadLiftMax) {
        Intent i = new Intent(this, HistoryCycleDetailActivity.class);
        i.putExtra(EXTRA_CYCLE_ID, cycleId);
        i.putExtra(EXTRA_DATE_AND_TIME, dateAndTime);
        i.putExtra(EXTRA_SQUAT_MAX, squatMax);
        i.putExtra(EXTRA_BENCH_MAX, benchMax);
        i.putExtra(EXTRA_PRESS_MAX, pressMax);
        i.putExtra(EXTRA_DEAD_LIFT_MAX, deadLiftMax);

        startActivity(i);
    }

    @Override
    public void setUpAdapterAndView(List<ListItem> listOfData) {
        this.listOfData = listOfData;
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        adapter = new CustomAdapter();
        recyclerView.setAdapter(adapter);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(
                recyclerView.getContext(),
                layoutManager.getOrientation()
        );

        itemDecoration.setDrawable(
                ContextCompat.getDrawable(
                        HistoryCycleListActivity.this,
                        R.drawable.divider_black
                )
        );

        recyclerView.addItemDecoration(
                itemDecoration
        );
    }

    private class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder>{

        @Override
        public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = layoutInflater.inflate(R.layout.item_cycle, parent, false);

            return new CustomViewHolder(v);
        }

        @Override
        public void onBindViewHolder(CustomViewHolder holder, int position) {
            ListItem currentItem = listOfData.get(position);

            String cycleNumber = "Cycle " + String.valueOf(currentItem.getCycleId());

            holder.message.setText(
                   cycleNumber
            );

            holder.dateAndTime.setText(
                    currentItem.getDateAndTime()
            );
        }

        @Override
        public int getItemCount() {
            // Helps the adapter decide how many items it will need to manage
            return listOfData.size();
        }

        class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

            private TextView dateAndTime;
            private TextView message;
            private ViewGroup container;

            public CustomViewHolder(View itemView) {
                super(itemView);

                this.dateAndTime = (TextView) itemView.findViewById(R.id.lbl_date_and_time);
                this.message = (TextView) itemView.findViewById(R.id.lbl_message);
                this.container = (ViewGroup) itemView.findViewById(R.id.root_list_item);

                this.container.setOnClickListener(this);

            }

            @Override
            public void onClick(View v) {
                ListItem listItem = listOfData.get(
                        this.getAdapterPosition()
                );

                controller.onListItemClick(
                        listItem
                );
            }
        }
    }
}
