/*2020.06.20
작성자:안한길
회원가입 화면 자바 코드
 */
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import static com.example.myapplication.Login.db;

public class registerAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText idText= (EditText) findViewById(R.id.register_id);
        final EditText pwdText= (EditText) findViewById(R.id.register_pwd);
        EditText nameText= (EditText) findViewById(R.id.register_name);
        final EditText hakbunText= (EditText) findViewById(R.id.register_hakbun);
        RadioButton studRad=(RadioButton) findViewById(R.id.register_student);
        RadioButton workstudRad=(RadioButton) findViewById(R.id.register_student_work);
        RadioButton taRad=(RadioButton) findViewById(R.id.register_ta);
        findViewById(R.id.register_end_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                db.userDao().insertAll(new Userinfo(idText.getText().toString(),pwdText.getText().toString(),
                        hakbunText.getText().toString()));
                Intent loginIntent =new Intent(registerAct.this,Login.class);
                registerAct.this.startActivity(loginIntent);
            }
        });
    }
}
