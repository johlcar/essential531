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

        TextView textView = view.findViewById(R.id.text_view_primary_title);

        Log.i(TAG, workout_name);

        switch(workout_name) {
            case "shoulder_press":
                textView.setText("Shoulder Press Sets");
                break;
            case "deadlift":
                textView.setText("Deadlift Sets");
                break;
            case "bench_press":
                textView.setText("Bench Press Sets");
                break;
            case "squat":
                textView.setText("Squat Sets");
                break;
        }

        TextView warmUpSetOneWeight = view.findViewById(R.id.warm_up_set_one_weight);
        warmUpSetOneWeight.setText(String.valueOf(workout_max));

        TextView warmUpSetTwoWeight = view.findViewById(R.id.warm_up_set_two_weight);
        warmUpSetTwoWeight.setText(String.valueOf(workout_max));

        TextView warmUpSetThreeWeight = view.findViewById(R.id.warm_up_set_three_weight);
        warmUpSetThreeWeight.setText(String.valueOf(workout_max));


        return view;
    }

}
