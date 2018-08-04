package com.johlcar.essential531.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.johlcar.essential531.db.TrainingCycleDao;
import com.johlcar.essential531.db.TrainingCycle;
import com.johlcar.essential531.db.TrainingCyclesDatabase;

import java.util.List;

public class TrainingCyclesViewModel extends AndroidViewModel {
    private TrainingCycleDao trainingCycleDao;
    private LiveData<List<TrainingCycle>> trainingCyclesLiveData;

    public TrainingCyclesViewModel(@NonNull Application application) {
        super(application);
        trainingCycleDao = TrainingCyclesDatabase.getDatabase(application).trainingCycleDao();
        trainingCyclesLiveData = trainingCycleDao.getAllTrainingCycles();
    }

    public TrainingCycle getTrainingCycleById(int id) {
        return trainingCycleDao.findTrainingCycleById(id);
    }

    public TrainingCycle getCurrentTrainingCycle(){
        return trainingCycleDao.findCurrentTrainingCycle();
    }

    public LiveData<List<TrainingCycle>> getTrainingCyclesList(){
        return trainingCyclesLiveData;
    }

    public void insert(TrainingCycle... trainingCycles){
        trainingCycleDao.insert(trainingCycles);
    }

    public void update(TrainingCycle trainingCycle){
        trainingCycleDao.update(trainingCycle);
    }

    public void deleteAll(){
        trainingCycleDao.deleteAll();
    }
}
