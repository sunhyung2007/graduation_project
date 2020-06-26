package com.example.myapplication;

/***************************************************************
 * 프로그램명 : Board_MainActivity
 * 작성자 : 2016039038 신동규
 * 작성일 : 2020.05.27 ~ 2020.06.26
 * 프로그램 설명 : 게시판 메인화면에 대한 스크립트
****************************************************************/

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class Board_MainActivity extends AppCompatActivity {

    private ListView listview;
    private ListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board_activity_main);

        //DB선언
        ListAppDatabase db = Room.databaseBuilder(this, ListAppDatabase.class, "ListDatabase-db").allowMainThreadQueries().build();

        //글쓰기 버튼 클릭 시
        Button writeButton = (Button)findViewById(R.id.BoardWriteButton);
        writeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), WritePage.class);
                startActivity(intent);
            }
        });

        //글삭제 버튼 클릭 시
        Button deleteButton = (Button)findViewById(R.id.BoardDeleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DeletePage.class);
                startActivity(intent);
            }
        });

        // Adapter 생성
        adapter = new ListViewAdapter();

        //데이터베이스 내 데이터를 불러옴
        for (int i = 0; i < db.listDatabaseDao().getAll().size(); i++) {
            ListViewItem tempData = new ListViewItem();

            tempData.setTitle(db.listDatabaseDao().getAll().get(i).getTitle());
            tempData.setWriter(db.listDatabaseDao().getAll().get(i).getWriter());
            tempData.setDesc(db.listDatabaseDao().getAll().get(i).getDesc());

            adapter.addItem(tempData);
        }

        // 리스트뷰 객체 생성 및 Adapter 설정
        listview = (ListView) findViewById(R.id.listview);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(listener);
    }

    //리스트뷰에서 특정 항목  클릭 시
    AdapterView.OnItemClickListener listener= new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            //인자를 전달함
            Intent intent = new Intent(getApplicationContext(), ListPage.class);
            intent.putExtra("titleContext", adapter.getItem(i).getTitle());
            intent.putExtra("writerContext", adapter.getItem(i).getWriter());
            intent.putExtra("descContext", adapter.getItem(i).getDesc());
            startActivity(intent);


        };
    };
}