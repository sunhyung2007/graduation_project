package com.example.myapplication;

/***************************************************************
 * 프로그램명 : ListPage
 * 작성자 : 2016039038 신동규
 * 작성일 : 2020.06.20 ~ 2020.06.26
 * 프로그램 설명 : 게시글 열람에 대한 스크립트
 ****************************************************************/

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class ListPage extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board_listview_itemview);

        //인자를 전달받고 데이터를 입력함
        String title = getIntent().getStringExtra("titleContext");
        TextView titleView = (TextView) this.findViewById(R.id.Board_titleContext);
        String writer = getIntent().getStringExtra("writerContext");
        TextView writerView = (TextView) this.findViewById(R.id.Board_writerContext);
        String desc = getIntent().getStringExtra("descContext");
        TextView descView = (TextView) this.findViewById(R.id.Board_descContext);

        //화면에 출력
        titleView.setText(title);
        writerView.setText(writer);
        descView.setText(desc);

    }
}