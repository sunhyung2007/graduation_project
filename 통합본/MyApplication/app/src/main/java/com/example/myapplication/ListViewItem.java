package com.example.myapplication;

/***************************************************************
 * 프로그램명 : ListViewItem
 * 작성자 : 2016039038 신동규
 * 작성일 : 2020.06.19 ~ 2020.06.26
 * 프로그램 설명 : 리스트뷰에 출력될 게시글에 대한 데이터 스크립트
 ****************************************************************/

public class ListViewItem {
    //리스트뷰 데이터
    private String title;
    private String writer;
    private String desc;

    //생성자
    public ListViewItem(String title, String writer, String desc){
        this.title = title;
        this.writer = writer;
        this.desc = desc;
    }

    //생성자 : ""로 초기화
    public ListViewItem() {
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
