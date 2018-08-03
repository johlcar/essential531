package com.johlcar.essential531.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.johlcar.essential531.R;

public class CurrentTrainingCycleMenuFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_current_training_cycle_menu, container, false);

        CardView cardViewShoulderPress = view.findViewById(R.id.card_view_shoulder_press);
        cardViewShoulderPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                Fragment currentTrainingCycleWorkoutFragment = new CurrentTrainingCycleWorkoutFragment();
                Bundle bundle = new Bundle();
                bundle.putString("item_selected_key", "shoulder_press");
                currentTrainingCycleWorkoutFragment.setArguments(bundle);

                activity.getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, currentTrainingCycleWorkoutFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        CardView cardViewDeadLift = view.findViewById(R.id.card_view_deadlift);
        cardViewDeadLift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                Fragment currentTrainingCycleWorkoutFragment = new CurrentTrainingCycleWorkoutFragment();
                Bundle bundle = new Bundle();
                bundle.putString("item_selected_key", "deadlift");
                currentTrainingCycleWorkoutFragment.setArguments(bundle);

                activity.getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, currentTrainingCycleWorkoutFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        CardView cardViewBenchPress = view.findViewById(R.id.card_view_bench_press);
        cardViewBenchPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                Fragment currentTrainingCycleWorkoutFragment = new CurrentTrainingCycleWorkoutFragment();
                Bundle bundle = new Bundle();
                bundle.putString("item_selected_key", "bench_press");
                currentTrainingCycleWorkoutFragment.setArguments(bundle);

                activity.getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, currentTrainingCycleWorkoutFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        CardView cardViewSquat = view.findViewById(R.id.card_view_squat);
        cardViewSquat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                Fragment currentTrainingCycleWorkoutFragment = new CurrentTrainingCycleWorkoutFragment();
                Bundle bundle = new Bundle();
                bundle.putString("item_selected_key", "squat");
                currentTrainingCycleWorkoutFragment.setArguments(bundle);

                activity.getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, currentTrainingCycleWorkoutFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;
    }

    public static CurrentTrainingCycleMenuFragment newInstance() {
        return new CurrentTrainingCycleMenuFragment();
    }
}
