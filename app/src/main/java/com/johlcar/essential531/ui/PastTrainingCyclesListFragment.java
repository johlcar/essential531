package com.johlcar.essential531.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.johlcar.essential531.R;
import com.johlcar.essential531.db.TrainingCycle;
import com.johlcar.essential531.viewmodel.TrainingCyclesViewModel;

import java.util.List;

public class PastTrainingCyclesListFragment extends Fragment {
    private PastTrainingCyclesListAdapter pastTrainingCyclesListAdapter;
    private TrainingCyclesViewModel trainingCyclesViewModel;
    private Context context;

    public static PastTrainingCyclesListFragment newInstance() {
        return new PastTrainingCyclesListFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        pastTrainingCyclesListAdapter = new PastTrainingCyclesListAdapter(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initData();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_past_training_cycle, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview_past_training_cycle);
        recyclerView.setAdapter(pastTrainingCyclesListAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        return view;
    }

    private void initData() {
        trainingCyclesViewModel = ViewModelProviders.of(this).get(TrainingCyclesViewModel.class);
        trainingCyclesViewModel.getTrainingCyclesList().observe(this, new Observer<List<TrainingCycle>>() {
            @Override
            public void onChanged(@Nullable List<TrainingCycle> trainingCycles) {
                pastTrainingCyclesListAdapter.setTrainingCycleList(trainingCycles);
            }
        });
    }

    public void removeData() {
        if (pastTrainingCyclesListAdapter != null) {
            trainingCyclesViewModel.deleteAll();
        }
    }


}



