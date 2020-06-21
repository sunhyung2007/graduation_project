package com.example.myapplication;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
interface ListDatabaseDao {

    @Query("SELECT * FROM ListDatabase")
    List<ListDatabase> getAll();

    @Insert
    void insert(ListDatabase listDatabase);

    @Insert
    void insertAll(ListDatabase... listDatabase);

    @Update
    void update(ListDatabase listDatabase);

    @Delete
    void delete(ListDatabase listDatabase);

    @Query("DELETE FROM ListDatabase")
    void deleteAll();


}