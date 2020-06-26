package com.example.myapplication;

import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = {UserDatabase.class},version = 2)
public abstract class AppDataBase extends RoomDatabase {
    public abstract UserDatabaseDao userDatabaseDao();
}
