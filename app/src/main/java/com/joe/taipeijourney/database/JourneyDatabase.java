package com.joe.taipeijourney.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.joe.taipeijourney.model.UserDataSource;

/**
 * author: Joe Cheng
 */
@Database(entities = {Journey.class}, version = 1, exportSchema = false)
public abstract class JourneyDatabase extends RoomDatabase {
    public abstract JourneyDao journeyDao();

    public static JourneyDatabase instance = null;

    public static JourneyDatabase getInstance(Context context)
    {
        if(instance == null)
        {
            instance = Room.databaseBuilder(context, JourneyDatabase.class, "journey.db").build();
        }
        return instance;
    }
}
