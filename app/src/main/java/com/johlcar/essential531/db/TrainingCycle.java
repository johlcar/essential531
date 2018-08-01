package com.johlcar.essential531.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcelable;

/**
 * Room db TrainingCycle object - contains attributes of a 5/3/1 training cycle
 */
@Entity(tableName = "training_cycle")
public class TrainingCycle {


    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "cid")
    public int cycleId;

    @ColumnInfo(name = "date_completed")
    public String dateCompleted;

    @ColumnInfo(name = "squat_max")
    public int squatMax;

    @ColumnInfo(name = "bench_press_max")
    public int benchPressMax;

    @ColumnInfo(name = "shoulder_press_max")
    public int shoulderPressMax;

    @ColumnInfo(name = "deadlift_max")
    public int deadliftMax;

    public TrainingCycle(String dateCompleted, int shoulderPressMax, int deadliftMax, int benchPressMax,
                         int squatMax) {
        this.dateCompleted = dateCompleted;
        this.shoulderPressMax = shoulderPressMax;
        this.deadliftMax = deadliftMax;
        this.benchPressMax = benchPressMax;
        this.squatMax = squatMax;
    }

}
