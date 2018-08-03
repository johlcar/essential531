package com.johlcar.essential531.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.johlcar.essential531.R;
import com.johlcar.essential531.db.TrainingCycle;

import java.util.List;

public class PastTrainingCyclesListAdapter extends RecyclerView.Adapter<PastTrainingCyclesListAdapter
        .PastTrainingCyclesViewHolder> {
    private LayoutInflater layoutInflater;
    private List<TrainingCycle> trainingCycleList;
    private Context context;

    public PastTrainingCyclesListAdapter(Context context) {
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    public void setTrainingCycleList(List<TrainingCycle> trainingCycleList) {
        this.trainingCycleList = trainingCycleList;
        notifyDataSetChanged();
    }

    @Override
    public PastTrainingCyclesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = layoutInflater.inflate(R.layout.item_list_past_training_cycle, parent, false);
        return new PastTrainingCyclesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PastTrainingCyclesViewHolder holder, int position) {
        if (trainingCycleList == null) {
            return;
        }

        final TrainingCycle trainingCycle = trainingCycleList.get(position);
        if (trainingCycle != null) {
            String cycleIdTitle = "Cycle #" + String.valueOf(trainingCycle.cycleId);

            holder.titleText.setText(cycleIdTitle);
            holder.dateCompletedText.setText(trainingCycle.dateCompleted);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    Fragment pastTrainingCyclesDetailFragment = new PastTrainingCyclesDetailFragment();
                    Bundle bundle = new Bundle();
                    bundle.putInt("item_selected_key", trainingCycle.cycleId);
                    pastTrainingCyclesDetailFragment.setArguments(bundle);

                    activity.getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.content_frame, pastTrainingCyclesDetailFragment)
                            .addToBackStack(null)
                            .commit();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if (trainingCycleList == null) {
            return 0;
        } else {
            return trainingCycleList.size();
        }
    }

    static class PastTrainingCyclesViewHolder extends RecyclerView.ViewHolder {
        private TextView titleText;
        private TextView dateCompletedText;

        public PastTrainingCyclesViewHolder(View itemView) {
            super(itemView);

            titleText = itemView.findViewById(R.id.cycleTitle);
            dateCompletedText = itemView.findViewById(R.id.cycleDateCompleted);
        }
    }
}
