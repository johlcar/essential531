package com.johlcar.essential531.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.johlcar.essential531.R;
import com.johlcar.essential531.db.TrainingCycle;
import com.johlcar.essential531.viewmodel.TrainingCyclesViewModel;

public class CurrentTrainingCycleMenuFragment extends Fragment {
    private TrainingCyclesViewModel trainingCyclesViewModel;
    private TrainingCycle currentTrainingCycle;
    private String itemSelected;
    private int itemSelectedWeight;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_current_training_cycle_menu, container, false);

        trainingCyclesViewModel = ViewModelProviders.of(this).get(TrainingCyclesViewModel.class);
        currentTrainingCycle = trainingCyclesViewModel.getCurrentTrainingCycle();

        CardView cardViewShoulderPress = view.findViewById(R.id.card_view_shoulder_press);
        cardViewShoulderPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemSelected = "shoulder_press";
                itemSelectedWeight = currentTrainingCycle.shoulderPressMax;
                jumpToDetailFragment(view, itemSelected, itemSelectedWeight);
            }
        });

        CardView cardViewDeadLift = view.findViewById(R.id.card_view_deadlift);
        cardViewDeadLift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemSelected = "deadlift";
                itemSelectedWeight = currentTrainingCycle.deadliftMax;
                jumpToDetailFragment(view, itemSelected, itemSelectedWeight);
            }
        });

        CardView cardViewBenchPress = view.findViewById(R.id.card_view_bench_press);
        cardViewBenchPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemSelected = "bench_press";
                itemSelectedWeight = currentTrainingCycle.benchPressMax;
                jumpToDetailFragment(view, itemSelected, itemSelectedWeight);
            }
        });

        CardView cardViewSquat = view.findViewById(R.id.card_view_squat);
        cardViewSquat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemSelected = "squat";
                itemSelectedWeight = currentTrainingCycle.squatMax;
                jumpToDetailFragment(view, itemSelected, itemSelectedWeight);
            }
        });

        return view;
    }

    public static CurrentTrainingCycleMenuFragment newInstance() {
        return new CurrentTrainingCycleMenuFragment();
    }

    //TODO: Refactor activities to handle fragment navigation
    private void jumpToDetailFragment(View view, String selected, int itemSelectedWeight){
        AppCompatActivity activity = (AppCompatActivity) view.getContext();
        Fragment currentTrainingCycleWorkoutFragment = new CurrentTrainingCycleWorkoutFragment();
        Bundle bundle = new Bundle();
        bundle.putString("item_selected_key", selected);
        bundle.putInt("item_selected_weight", itemSelectedWeight);
        currentTrainingCycleWorkoutFragment.setArguments(bundle);

        activity.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, currentTrainingCycleWorkoutFragment)
                .addToBackStack(null)
                .commit();
    }
}
