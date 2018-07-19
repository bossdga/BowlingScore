package com.paradoxcat.bowlingscore.persistence;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Class that represents a Room database
 */
public abstract class AppDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "bowling_db";
    private static AppDatabase INSTANCE;

    abstract BowlingDao bowlingDao();

    static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, DATABASE_NAME)
                            .build();

                }
            }
        }
        return INSTANCE;
    }

}