package com.example.myapplication;

/***************************************************************
 * 프로그램명 : WritePage
 * 작성자 : 2016039038 신동규
 * 작성일 : 2020.06.20 ~ 2020.06.26
 * 프로그램 설명 : 게시글 작성에 대한 스크립트
 ****************************************************************/

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class WritePage extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board_write_page);

        //작성공간을 읽어옴
        final EditText editTitleText = findViewById(R.id.editTitle);
        final EditText editWriterText = findViewById(R.id.editWriter);
        final EditText editDescText = findViewById(R.id.editDesc);

        //DB선언
        final ListAppDatabase db = Room.databaseBuilder(this, ListAppDatabase.class, "ListDatabase-db").allowMainThreadQueries().build();

        //완료 버튼을 클릭 시
        Button BoardFinishButton = (Button)findViewById(R.id.finishButton);
        BoardFinishButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //입력이 끝나지 않은 경우
                if (editTitleText.getText().toString().matches("") || editWriterText.getText().toString().matches("") || editDescText.getText().toString().matches(""))
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(WritePage.this);
                    builder.setMessage("빈공간을 채워주세요");
                    builder.setPositiveButton("OK", null);
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
                else {  //입력이 완료되었을 때
                    //데이터베이스 입력
                    db.listDatabaseDao().insert(new ListDatabase(editTitleText.getText().toString(), editWriterText.getText().toString(), editDescText.getText().toString()));
                    Intent intent = new Intent(getApplicationContext(), Board_MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
