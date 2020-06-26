package com.example.myapplication;

/*
 * 작성자 : 2016039059 김선형
 * 수정일 : 2020.06.26
 * 프로그램명 : 입학연도 체크리스트
 * 프로그램 설명 : 사용자의 입학년도 체크리스트 뷰
 **************************************/
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CheckList_MainActivity extends AppCompatActivity {

    private RadioGroup rg_year;
    private RadioButton btn_2016,btn_2017,btn_2018,btn_2019;
    private Button btn_move;
    private String str_result;
    public static AppDataBase db_DEC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checklist_activity_main);
        //if(db_DEC==null)
          db_DEC = Room.databaseBuilder(this, AppDataBase.class, "ListDatabase-db").allowMainThreadQueries().build();
        Intent intent=getIntent();
        final String userID =intent.getStringExtra("userID");//유저아이디 받아옴
        //final String userID="idg";
        rg_year = findViewById(R.id.rg_year);
        btn_2016 = findViewById(R.id.btn_2016);
        btn_2017 = findViewById(R.id.btn_2017);
        btn_2018 = findViewById(R.id.btn_2018);
        btn_2019 = findViewById(R.id.btn_2019);
        btn_move = findViewById(R.id.btn_move);

        rg_year.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.btn_2016){
                    Toast.makeText(CheckList_MainActivity.this,"2016학번의 졸업요건 체크리스트",Toast.LENGTH_SHORT).show();
                    str_result = btn_2016.getText().toString();
                }
               else if (i == R.id.btn_2017){
                    Toast.makeText(CheckList_MainActivity.this,"2017학번의 졸업요건 체크리스트",Toast.LENGTH_SHORT).show();
                    str_result = btn_2017.getText().toString();
                }
                else if (i == R.id.btn_2018){
                    Toast.makeText(CheckList_MainActivity.this,"2018학번의 졸업요건 체크리스트",Toast.LENGTH_SHORT).show();
                    str_result = btn_2018.getText().toString();
                }
                else if (i == R.id.btn_2019){
                    Toast.makeText(CheckList_MainActivity.this,"2019학번의 졸업요건 체크리스트",Toast.LENGTH_SHORT).show();
                    str_result = btn_2019.getText().toString();
                }

            }
        });
        btn_move.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(str_result == btn_2016.getText().toString()){
                    Intent intent = new Intent(CheckList_MainActivity.this,yearof2016.class);
                    intent.putExtra("userID", userID);//아이디
                    startActivity(intent);
                }
             else if(str_result == btn_2017.getText().toString()){
                    Intent intent = new Intent(CheckList_MainActivity.this,yearof2017.class);
                    intent.putExtra("userID", userID);//아이디
                    startActivity(intent);
                }
                else if(str_result == btn_2018.getText().toString()){
                    Intent intent = new Intent(CheckList_MainActivity.this,yearof2018.class);
                    intent.putExtra("userID", userID);//아이디
                    startActivity(intent);
                }
                else if(str_result == btn_2019.getText().toString()){
                    Intent intent = new Intent(CheckList_MainActivity.this,yearof2019.class);
                    intent.putExtra("userID", userID);//아이디
                    startActivity(intent);
                }
                else{
                    Toast.makeText(CheckList_MainActivity.this,"다시 선택해주세요",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

}
