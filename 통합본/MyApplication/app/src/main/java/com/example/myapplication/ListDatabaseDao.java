package com.example.myapplication;

/***************************************************************
 * 프로그램명 : ListDatabaseDao
 * 작성자 : 2016039038 신동규
 * 작성일 : 2020.06.21 ~ 2020.06.26
 * 프로그램 설명 : 데이터베이스의 함수에 대한 스크립트
 ****************************************************************/

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
interface ListDatabaseDao {

    //리스트를 불러옴
    @Query("SELECT * FROM ListDatabase")
    List<ListDatabase> getAll();

    //데이터 입력
    @Insert
    void insert(ListDatabase listDatabase);

    //다수의 데이터 입력
    @Insert
    void insertAll(ListDatabase... listDatabase);

    //데이터 수정
    @Update
    void update(ListDatabase listDatabase);

    //데이터 삭제
    @Delete
    void delete(ListDatabase listDatabase);

    //데이터 전부 삭제
    @Query("DELETE FROM ListDatabase")
    void deleteAll();


}