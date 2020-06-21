package com.example.myapplication;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {ListDatabase.class}, version = 1)
public abstract class ListAppDatabase extends RoomDatabase {
    public abstract ListDatabaseDao listDatabaseDao();

}
