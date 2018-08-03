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

    public static CurrentTrainingCycleWorkoutFragment newInstance(){
        return new CurrentTrainingCycleWorkoutFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        workout_name = bundle.getString("item_selected_key");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_current_training_cycle_workout, container, false);

        TextView textView = view.findViewById(R.id.text_view_workout);

        Log.i(TAG, workout_name);

        switch(workout_name) {
            case "shoulder_press":
                textView.setText("Shoulder Press");
                break;
            case "deadlift":
                textView.setText("Deadlift");
                break;
            case "bench_press":
                textView.setText("Bench Press");
                break;
            case "squat":
                textView.setText("Squat");
                break;
        }

        return view;
    }

}
