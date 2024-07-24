package com.example.cronometro.save;

import android.content.Context;

import androidx.room.Room;

import com.example.cronometro.database.AppDatabase;
import com.example.cronometro.database.CronometerDao;

import java.util.List;

public class ConectDataBase implements SaveData{
    private static ConectDataBase instance = null;
    private final CronometerDao cronometerDao;

    private ConectDataBase(Context context) {
        AppDatabase db = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "cronometroDB").allowMainThreadQueries().build();
        cronometerDao = db.cronometerDao();
    }

    public static synchronized ConectDataBase getInstance(Context context){
        if (null == instance)
            instance = new ConectDataBase(context);
        return instance;
    }

    @Override
    public void getAll() {
        List<String> times = cronometerDao.getAll();
    }

    @Override
    public void insertDB(String time) {
        cronometerDao.insertDB(time);
    }
}
