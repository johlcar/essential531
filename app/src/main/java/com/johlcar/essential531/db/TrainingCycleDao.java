package com.johlcar.essential531.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface TrainingCycleDao {

    @Query("SELECT * FROM training_cycle WHERE cid = :id LIMIT 1")
    TrainingCycle findTrainingCycleById(int id);

    @Query("SELECT * FROM training_cycle ORDER BY cid DESC LIMIT 1")
    TrainingCycle findCurrentTrainingCycle();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(TrainingCycle trainingCycle);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(TrainingCycle... trainingCycles);

    @Update(onConflict = OnConflictStrategy.IGNORE)
    void update(TrainingCycle trainingCycle);

    @Query("DELETE FROM training_cycle")
    void deleteAll();

    @Query("Select * FROM training_cycle ORDER BY cid ASC")
    LiveData<List<TrainingCycle>> getAllTrainingCycles();

}
