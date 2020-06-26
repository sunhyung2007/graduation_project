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

    @Query("SELECT * FROM UserDatabase where user_id LIKE :userID")
    List<UserDatabase> find_DEC(String userID);
    @Query("DELETE  FROM UserDatabase where user_id LIKE :userID AND list_num LIKE :num")
    void delete_dec(String userID,int num);
    @Query("update UserDatabase set list_num = :num where i is :pk_i ")
    void update_num(int num,int pk_i);
    @Query("SELECT * FROM UserDatabase where user_id LIKE :userID AND i LIKE :pk_i")
    UserDatabase find_DEC_num(String userID,int pk_i);
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
