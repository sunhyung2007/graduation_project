package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ListView listview;
    private ListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button writeButton = (Button)findViewById(R.id.BoardWriteButton);
        writeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), WritePage.class);
                startActivity(intent);
            }
        });

        // Adapter 생성
        adapter = new ListViewAdapter();

        // 리스트뷰 객체 생성 및 Adapter 설정
        listview = (ListView) findViewById(R.id.listview);
        listview.setAdapter(adapter);

        //test
        adapter.addItem("자유게시판 이용방침입니다.", "운영자", "이 게시판에선 자유로운 주제로 이야기를 나눌 수 있습니다.");
        adapter.addItem("앱 업데이트 관련 정보", "운영자", "내용");
        adapter.addItem("이용자 질문사항에 대해서", "운영자", "내용");

        listview.setOnItemClickListener(listener);
    }

    AdapterView.OnItemClickListener listener= new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Intent intent = new Intent(getApplicationContext(), ListPage.class);
            intent.putExtra("titleContext", adapter.getItem(i).getTitle());
            intent.putExtra("writerContext", adapter.getItem(i).getWriter());
            intent.putExtra("descContext", adapter.getItem(i).getDesc());
            startActivity(intent);


        };
    };
}