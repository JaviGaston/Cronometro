package com.example.cronometro.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class DBCronometer {
    @PrimaryKey (autoGenerate = true)
    public int id;

    @ColumnInfo (name = "tiempo")
    public String time;
}
