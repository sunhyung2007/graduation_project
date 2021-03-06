package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rg_year;
    private RadioButton btn_2016,btn_2017,btn_2018,btn_2019;
    private Button btn_move;
    private String str_result;
    public static AppDataBase db_DEC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(db_DEC==null)
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
                    Toast.makeText(MainActivity.this,"2016학번의 졸업요건 체크리스트",Toast.LENGTH_SHORT).show();
                    str_result = btn_2016.getText().toString();
                }
               else if (i == R.id.btn_2017){
                    Toast.makeText(MainActivity.this,"2017학번의 졸업요건 체크리스트",Toast.LENGTH_SHORT).show();
                    str_result = btn_2017.getText().toString();
                }
                else if (i == R.id.btn_2018){
                    Toast.makeText(MainActivity.this,"2018학번의 졸업요건 체크리스트",Toast.LENGTH_SHORT).show();
                    str_result = btn_2018.getText().toString();
                }
                else if (i == R.id.btn_2019){
                    Toast.makeText(MainActivity.this,"2019학번의 졸업요건 체크리스트",Toast.LENGTH_SHORT).show();
                    str_result = btn_2019.getText().toString();
                }

            }
        });
        btn_move.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(str_result == btn_2016.getText().toString()){
                    Intent intent = new Intent(MainActivity.this,yearof2016.class);
                    intent.putExtra("userID", userID);//아이디
                    startActivity(intent);
                }
             else if(str_result == btn_2017.getText().toString()){
                    Intent intent = new Intent(MainActivity.this,yearof2017.class);
                    intent.putExtra("userID", userID);//아이디
                    startActivity(intent);
                }
                else if(str_result == btn_2018.getText().toString()){
                    Intent intent = new Intent(MainActivity.this,yearof2018.class);
                    intent.putExtra("userID", userID);//아이디
                    startActivity(intent);
                }
                else if(str_result == btn_2019.getText().toString()){
                    Intent intent = new Intent(MainActivity.this,yearof2019.class);
                    intent.putExtra("userID", userID);//아이디
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this,"다시 선택해주세요",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

}