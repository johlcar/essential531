package com.johlcar.essential531.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.johlcar.essential531.R;

public class CurrentTrainingCycleWorkoutFragment extends Fragment {
    private static final String TAG = "CurrentTrainingCycle";
    private String workout_name;
    private int workout_max;
    private double[] weightPercentage;

    public static CurrentTrainingCycleWorkoutFragment newInstance(){
        return new CurrentTrainingCycleWorkoutFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        workout_name = bundle.getString("item_selected_key");
        workout_max = bundle.getInt("item_selected_weight");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_current_training_cycle_workout, container, false);

        TextView textViewPrimaryTitle = view.findViewById(R.id.text_view_primary_title);

        Log.i(TAG, workout_name);

        switch(workout_name) {
            case "shoulder_press":
                textViewPrimaryTitle.setText("Shoulder Press Sets");
                break;
            case "deadlift":
                textViewPrimaryTitle.setText("Deadlift Sets");
                break;
            case "bench_press":
                textViewPrimaryTitle.setText("Bench Press Sets");
                break;
            case "squat":
                textViewPrimaryTitle.setText("Squat Sets");
                break;
        }

        TextView warmUpSetOneWeight = view.findViewById(R.id.warm_up_set_one_weight);
        warmUpSetOneWeight.setText(String.valueOf(workout_max));

        TextView warmUpSetTwoWeight = view.findViewById(R.id.warm_up_set_two_weight);
        warmUpSetTwoWeight.setText(String.valueOf(workout_max));

        TextView warmUpSetThreeWeight = view.findViewById(R.id.warm_up_set_three_weight);
        warmUpSetThreeWeight.setText(String.valueOf(workout_max));

        TextView primarySetOneWeight = view.findViewById(R.id.primary_set_one_weight);
        primarySetOneWeight.setText(String.valueOf(workout_max));

        TextView primarySetTwoWeight = view.findViewById(R.id.primary_set_two_weight);
        primarySetTwoWeight.setText(String.valueOf(workout_max));

        TextView primarySetThreeWeight = view.findViewById(R.id.primary_set_three_weight);
        primarySetThreeWeight.setText(String.valueOf(workout_max));

        TextView accessorySetOneWeight = view.findViewById(R.id.accessory_set_one_weight);
        accessorySetOneWeight.setText(String.valueOf(workout_max));

        TextView accessorySetTwoWeight = view.findViewById(R.id.accessory_set_two_weight);
        accessorySetTwoWeight.setText(String.valueOf(workout_max));

        TextView accessorySetThreeWeight = view.findViewById(R.id.accessory_set_three_weight);
        accessorySetThreeWeight.setText(String.valueOf(workout_max));

        TextView accessorySetFourWeight = view.findViewById(R.id.accessory_set_four_weight);
        accessorySetFourWeight.setText(String.valueOf(workout_max));

        TextView accessorySetFiveWeight = view.findViewById(R.id.accessory_set_five_weight);
        accessorySetFiveWeight.setText(String.valueOf(workout_max));

        
        return view;
    }

    private void setWeightValues(TextView textView, double weightPercentage){

    }

}
