package com.example.myapplication;

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

    @PrimaryKey
    @NotNull
    private String title;
    private String writer;
    private String desc;

    public ListDatabase(String title, String writer, String desc){
        this.title = title;
        this.writer = writer;
        this.desc = desc;
    }

    public ListDatabase() {
        this.title = "";
        this.writer = "";
        this.desc = "";
    }

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