
/*
* 코드명 : UserDao.java
* 작성자 : 안한길
* 작성일 : 2020.06.20
* 코드 설명: 로그인에 사용될 쿼리문을 작성한 코드
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
