package com.johlcar.essential531.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

@Database(entities = {TrainingCycle.class}, version = 1)
public abstract class TrainingCyclesDatabase extends RoomDatabase {
    private static TrainingCyclesDatabase INSTANCE;
    private static final String DB_NAME = "training_cycles.db";

    public static TrainingCyclesDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (TrainingCyclesDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            TrainingCyclesDatabase.class, DB_NAME)
                            .allowMainThreadQueries() // SHOULD NOT BE USED IN PRODUCTION !!!
                            .addCallback(new RoomDatabase.Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);
                                    Log.d("TrainingCyclesDatabase", "populating with data...");
                                    new PopulateDbAsync(INSTANCE).execute();
                                }
                            })
                            .build();
                }
            }
        }

        return INSTANCE;
    }

    public void clearDb() {
        if (INSTANCE != null) {
            new PopulateDbAsync(INSTANCE).execute();
        }
    }

    public abstract TrainingCycleDao trainingCycleDao();

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
        private final TrainingCycleDao trainingCycleDao;

        public PopulateDbAsync(TrainingCyclesDatabase instance) {
            trainingCycleDao = instance.trainingCycleDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            trainingCycleDao.deleteAll();

            TrainingCycle trainingCycleOne = new TrainingCycle("12/23/18", 150, 300, 340, 235);
            TrainingCycle trainingCycleTwo = new TrainingCycle("1/24/19", 155, 310, 350, 240);
            TrainingCycle trainingCycleThree = new TrainingCycle("2/25/19", 160, 320, 360, 245);
            TrainingCycle trainingCycleFour = new TrainingCycle("3/26/19", 165, 330, 370, 250);

            trainingCycleDao.insert(trainingCycleOne, trainingCycleTwo, trainingCycleThree, trainingCycleFour);

            return null;
        }
    }
}
