/*
* 코드명 : DBlogin.java
* 작성자 : 안한길
* 작성일 : 2020.06.20
* 코드 설명 : room을 사용한 db 생성
 */
package com.example.myapplication;

import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = {Userinfo.class},version = 1)
public abstract class DBlogin extends RoomDatabase {
    public abstract UserDao userDao();
}
