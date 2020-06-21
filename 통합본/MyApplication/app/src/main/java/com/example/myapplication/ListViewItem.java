package com.example.myapplication;

public class ListViewItem {
    private String title;
    private String writer;
    private String desc;

    public ListViewItem(String title, String writer, String desc){
        this.title = title;
        this.writer = writer;
        this.desc = desc;
    }

    public ListViewItem() {
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
