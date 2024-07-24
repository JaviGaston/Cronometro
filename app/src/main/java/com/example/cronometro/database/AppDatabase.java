package com.example.cronometro.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {DBCronometer.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CronometerDao cronometerDao();
}
