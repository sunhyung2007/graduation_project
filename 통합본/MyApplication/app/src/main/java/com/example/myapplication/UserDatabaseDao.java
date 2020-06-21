package com.example.myapplication;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
interface UserDatabaseDao {

    @Query("SELECT * FROM UserDatabase")
    List<UserDatabase> getAll();

    @Insert
    void insert(UserDatabase userDatabase);

    @Insert
    void insertAll(UserDatabase... userDatabase);

    @Update
    void update(UserDatabase userDatabase);

    @Delete
    void delete(UserDatabase userDatabase);

    @Query("DELETE FROM UserDatabase")
    void deleteAll();


}
