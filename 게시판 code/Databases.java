package com.example.myapplication;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.PrimaryKey;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Entity
class Listviews {

    @PrimaryKey
    private String title;
    private String writer;
    private String desc;
}

@Dao
interface UserDao {

    @Query("SELECT * FROM listviews")
    List<Listviews> getAll();

    @Insert
    void insertAll(Listviews... listviews);

    @Update
    void updateDownData(Listviews listviews);

    @Delete
    void delete(Listviews listviews);

    @Query("DELETE FROM listviews")
    void deleteAll();


}