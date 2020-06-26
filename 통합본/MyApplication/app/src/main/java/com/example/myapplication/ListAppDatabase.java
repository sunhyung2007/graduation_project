package com.example.myapplication;

/***************************************************************
 * 프로그램명 : ListAppDatabase
 * 작성자 : 2016039038 신동규
 * 작성일 : 2020.06.21 ~ 2020.06.26
 * 프로그램 설명 : 데이터베이스의 추상클래스를 제공하는 스크립트
 ****************************************************************/

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {ListDatabase.class}, version = 1)
public abstract class ListAppDatabase extends RoomDatabase {
    //데이터베이스를 선언
    public abstract ListDatabaseDao listDatabaseDao();

}
