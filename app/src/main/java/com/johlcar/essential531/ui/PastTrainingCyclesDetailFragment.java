package com.johlcar.essential531.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.johlcar.essential531.R;
import com.johlcar.essential531.db.TrainingCycle;
import com.johlcar.essential531.viewmodel.PastTrainingCyclesViewModel;

public class PastTrainingCyclesDetailFragment extends Fragment {
    private PastTrainingCyclesViewModel pastTrainingCyclesViewModel;
    private Context context;
    private TrainingCycle pastTrainingCycleDetailItem;

    private static final String TAG = "DetailFragment:";

    public static PastTrainingCyclesDetailFragment newInstance(){
        return new PastTrainingCyclesDetailFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        int cid = bundle.getInt("item_selected_key");

        pastTrainingCyclesViewModel = ViewModelProviders.of(this).get(PastTrainingCyclesViewModel.class);
        pastTrainingCycleDetailItem = pastTrainingCyclesViewModel.getTrainingCycleById(cid);
        Log.i(TAG, "Cycle id: " + String.valueOf(pastTrainingCycleDetailItem.dateCompleted));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_past_training_cycle_detail, container, false);

        TableLayout tableLayoutShoulderPress = (TableLayout) view.findViewById(R.id.table_squat);
        TableLayout tableLayoutDeadlift = (TableLayout) view.findViewById(R.id.table_squat);
        TableLayout tableLayoutBenchPress = (TableLayout) view.findViewById(R.id.table_squat);
        TableLayout tableLayoutSquat = (TableLayout) view.findViewById(R.id.table_squat);


        showTableLayout(tableLayoutShoulderPress, pastTrainingCycleDetailItem.shoulderPressMax, "Shoulder Press");
        showTableLayout(tableLayoutDeadlift, pastTrainingCycleDetailItem.deadliftMax, "Deadlift");
        showTableLayout(tableLayoutBenchPress, pastTrainingCycleDetailItem.benchPressMax, "Bench Press");
        showTableLayout(tableLayoutSquat, pastTrainingCycleDetailItem.squatMax, "Squat");

        return view;
    }

    //TODO: Format table's appearance, add sets column, add assistance exercises
    public void showTableLayout(TableLayout table, int trainingMax, String tableTitle){

        String[] weeks = {"Week 1", "Week 2", "Week 3", "Week 4"};
        double[][] tableValues = {{.65, .70, .75, .40}, {.75, .80, .85, .50}, {.85, .90, .95, .60}};
        String[][] tableValuesToStrings = new String[tableValues.length][];

        // Calculate real weight values from maxes
        for (int i = 0; i < tableValues.length; i++) {

            tableValuesToStrings[i] = new String[tableValues[i].length];

            for (int j = 0; j < tableValues[i].length; j++) {

                tableValuesToStrings[i][j] = String.valueOf(5*(Math.round((tableValues[i][j] * trainingMax)/5)));
            }
        }

        // Generate table rows and text views of table layout
        for (int i = 0; i < tableValuesToStrings.length; i++) {

            TableRow tableRow = new TableRow(getActivity());

            if(i == 0){

                TableRow tableRowLegendMax = new TableRow(getActivity());
                TextView tableValueMax = new TextView(getActivity());
                tableValueMax.setText(tableTitle);
                tableRowLegendMax.addView(tableValueMax);
                table.addView(tableRowLegendMax);

                TableRow tableRowLegendWeek = new TableRow(getActivity());
                for (int j = 0; j < weeks.length; j++){

                    TextView tableValueWeek = new TextView(getActivity());
                    tableValueWeek.setText(weeks[j]);
                    tableValueWeek.setGravity(Gravity.CENTER);
                    tableRowLegendWeek.addView(tableValueWeek);
                }

                table.addView(tableRowLegendWeek);
            }

            for (int j = 0; j < tableValuesToStrings[i].length; j++){

                TextView tableValue = new TextView(getActivity());
                tableValue.setText(tableValuesToStrings[i][j]);
                tableValue.setGravity(Gravity.CENTER);
                tableRow.addView(tableValue);
            }


            table.addView(tableRow);
        }
    }
}
