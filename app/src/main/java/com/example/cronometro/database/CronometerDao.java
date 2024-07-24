package com.example.cronometro.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CronometerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertDB(String time);

    @Query("SELECT tiempo from cronometro")
    List<String>  getAll();
}
