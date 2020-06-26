/*2020.06.20
작성자:안한길
userinfo table에 쓰일 명령어 선언
 */
package com.example.myapplication;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM Userinfo")
    List<Userinfo> getAll();

    @Query("SELECT * FROM Userinfo WHERE user_id LIKE :userId AND user_pwd LIKE :userPwd")
    Userinfo loginApp(String userId,String userPwd);

    @Insert
    void insertAll(Userinfo... users);

    @Delete
    void delete(Userinfo user);
}
