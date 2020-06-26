package com.example.myapplication;

/***************************************************************
 * 프로그램명 : DeletePage
 * 작성자 : 2016039038 신동규
 * 작성일 : 2020.06.21 ~ 2020.06.26
 * 프로그램 설명 : 게시글 삭제화면에 대한 스크립트
 ****************************************************************/

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class DeletePage extends AppCompatActivity {
    private ListView listview;
    private ListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board_main_delete);

        //DB선언
        final ListAppDatabase db = Room.databaseBuilder(this, ListAppDatabase.class, "ListDatabase-db").allowMainThreadQueries().build();

        // Adapter 생성
        adapter = new ListViewAdapter();
        adapter.setDelMode(true);

        //데이터베이스의 데이터를 읽어옴
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

        //삭제버튼 입력 시
        Button deleteButton = (Button)findViewById(R.id.BoardDeleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                for (int i = db.listDatabaseDao().getAll().size() - 1; i >= 0; i--) {
                    if (adapter.getDelCheck(i, listview)) {
                        //데이터베이스 내에 데이터 삭제
                        db.listDatabaseDao().delete(db.listDatabaseDao().getAll().get(i));
                    }
                }

                Intent intent = new Intent(getApplicationContext(), Board_MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
