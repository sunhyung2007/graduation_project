package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.myapplication.CheckList_MainActivity.db_DEC;

public class listview extends AppCompatActivity {
    TextView tv_hard;
    TextView tv_sub;
    TextView tv_basic;
    TextView tv_nes;

    TextView tv_select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        Intent intent=getIntent();
        String userID =intent.getStringExtra("userID");//유저아이디 받아옴
        int list_pk=intent.getIntExtra("pk_i",0);
        tv_basic = (TextView)findViewById(R.id.basic_text);
        tv_hard = (TextView)findViewById(R.id.hard_text);
        tv_sub = (TextView)findViewById(R.id.sub_text);
        tv_nes = (TextView)findViewById(R.id.nes_text);
        tv_select= (TextView)findViewById(R.id.select_text);
        final UserDatabase list_DEC= db_DEC.userDatabaseDao().find_DEC_num(userID,list_pk);
        tv_basic.setText(list_DEC.getBasic());
        tv_sub.setText(list_DEC.getSub());
        tv_hard.setText(list_DEC.getHard());
        tv_nes.setText(list_DEC.getNes1()+list_DEC.getNes2());
        tv_select.setText(list_DEC.getSelect1()+list_DEC.getSelect2()+list_DEC.getSelect3());
    }
}
