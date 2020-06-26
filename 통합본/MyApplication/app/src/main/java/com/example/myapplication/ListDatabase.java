package com.example.myapplication;

/***************************************************************
 * 프로그램명 : ListDatabase
 * 작성자 : 2016039038 신동규
 * 작성일 : 2020.06.19 ~ 2020.06.26
 * 프로그램 설명 : 게시글에 대한 데이터베이스의 형태와 공간에 대한 스크립트
 ****************************************************************/

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.PrimaryKey;
import androidx.room.Query;
import androidx.room.Update;

import org.jetbrains.annotations.NotNull;

import java.util.List;

@Entity
class ListDatabase {

    //데이터베이스 내 데이터
    @PrimaryKey
    @NotNull
    private String title;
    private String writer;
    private String desc;

    //생성자
    public ListDatabase(String title, String writer, String desc){
        this.title = title;
        this.writer = writer;
        this.desc = desc;
    }

    //생성자 : ""로 초기화
    public ListDatabase() {
        this.title = "";
        this.writer = "";
        this.desc = "";
    }

    //set
    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setWriter(String writer)
    {
        this.writer = writer;
    }

    public void setDesc(String desc)
    {
        this.desc = desc;
    }

    //get
    public String getTitle()
    {
        return this.title;
    }

    public String getWriter()
    {
        return this.writer;
    }

    public String getDesc()
    {
        return this.desc;
    }
}