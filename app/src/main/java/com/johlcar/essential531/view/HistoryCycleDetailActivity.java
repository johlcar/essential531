package com.johlcar.essential531.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.johlcar.essential531.R;

public class HistoryCycleDetailActivity extends AppCompatActivity {

    private static final String EXTRA_CYCLE_ID = "EXTRA_CYCLE_ID";
    private static final String EXTRA_DATE_AND_TIME = "EXTRA_DATE_AND_TIME";
    private static final String EXTRA_SQUAT_MAX = "EXTRA_SQUAT_MAX";
    private static final String EXTRA_BENCH_MAX = "EXTRA_BENCH_MAX";
    private static final String EXTRA_PRESS_MAX = "EXTRA_PRESS_MAX";
    private static final String EXTRA_DEAD_LIFT_MAX = "EXTRA_DEAD_LIFT_MAX ";

    private TableLayout mTableLayoutSquat;
    private TableLayout mTableLayoutBenchPress;
    private TableLayout mTableLayoutPress;
    private TableLayout mTableLayoutDeadLift;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_cycle_detail);

        Intent i = getIntent();
        int cycleIdExtra = i.getIntExtra(EXTRA_CYCLE_ID, 0);
        String dateAndTimeExtra = i.getStringExtra(EXTRA_DATE_AND_TIME);
        int squatMaxExtra = i.getIntExtra(EXTRA_SQUAT_MAX, 0);
        int benchMaxExtra = i.getIntExtra(EXTRA_BENCH_MAX, 0);
        int pressMaxExtra = i.getIntExtra(EXTRA_PRESS_MAX, 0);
        int deadLiftMaxExtra = i.getIntExtra(EXTRA_DEAD_LIFT_MAX, 0);

        String squatDescription = "Squat Training Max: " + String.valueOf(squatMaxExtra);
        String benchPressDescription = "Bench Press Training Max: " + String.valueOf(benchMaxExtra);
        String pressDescription = "Press Training Max: " + String.valueOf(pressMaxExtra);
        String deadliftDescription = "Deadlift Training Max: " + String.valueOf(deadLiftMaxExtra);

        mTableLayoutSquat = (TableLayout) findViewById(R.id.table_squat);
        mTableLayoutBenchPress = (TableLayout) findViewById(R.id.table_bench_press);
        mTableLayoutPress = (TableLayout) findViewById(R.id.table_press);
        mTableLayoutDeadLift = (TableLayout) findViewById(R.id.table_dead_lift);


        showTableLayout(mTableLayoutSquat, squatMaxExtra, squatDescription);
        showTableLayout(mTableLayoutBenchPress, benchMaxExtra, benchPressDescription);
        showTableLayout(mTableLayoutPress, pressMaxExtra, pressDescription);
        showTableLayout(mTableLayoutDeadLift, deadLiftMaxExtra, deadliftDescription);

    }

    // TODO: Format table's appearance, add set numbers to TextView values
    /**
     * Generates TableLayouts for each primary lift in the 5/3/1 program for the history detail
     * views.  Each table contains the past workout sets of the main lifts over the past cycle.
     * @param table - Id of the TableLayout to be generated
     * @param trainingMax - Integer value of user's training max for the respective lift
     * @param description - String value containing which lift is being generated
     */
    public void showTableLayout(TableLayout table, int trainingMax, String description){

        String[] weeks = {"Week 1", "Week 2", "Week 3", "Week 4"};
        double[][] tableValues = {{.65, .70, .75, .40}, {.75, .80, .85, .50}, {.85, .90, .95, .60}};
        String[][] tableValuesToStrings = new String[tableValues.length][];

        // Calculate set weights from training maxes
        // Store in String container
        for (int i = 0; i < tableValues.length; i++) {

            tableValuesToStrings[i] = new String[tableValues[i].length];

            for (int j = 0; j < tableValues[i].length; j++) {

                tableValuesToStrings[i][j] = String.valueOf(5*(Math.round((tableValues[i][j] * trainingMax)/5)));
            }
        }

        // Generate table rows and text views of our table layout
        // Display weight value in each text view
        for (int i = 0; i < tableValuesToStrings.length; i++) {

            TableRow tableRow = new TableRow(this);

            if(i == 0){

                TableRow tableRowLegendMax = new TableRow(this);
                TextView tableValueMax = new TextView(this);
                tableValueMax.setText(description);
                tableRowLegendMax.addView(tableValueMax);
                table.addView(tableRowLegendMax);

                TableRow tableRowLegendWeek = new TableRow(this);
                for (int j = 0; j < weeks.length; j++){

                    TextView tableValueWeek = new TextView(this);
                    tableValueWeek.setText(weeks[j]);
                    tableValueWeek.setGravity(Gravity.CENTER);
                    tableRowLegendWeek.addView(tableValueWeek);
                }

                table.addView(tableRowLegendWeek);
            }

            for (int j = 0; j < tableValuesToStrings[i].length; j++){

                TextView tableValue = new TextView(this);
                tableValue.setText(tableValuesToStrings[i][j]);
                tableValue.setGravity(Gravity.CENTER);
                tableRow.addView(tableValue);
            }


            table.addView(tableRow);
        }
    }
}


