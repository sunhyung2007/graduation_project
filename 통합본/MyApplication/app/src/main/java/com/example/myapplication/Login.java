/*2020.06.20
작성자:안한길
로그인 화면 자바 코드
 */
package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {
   public static DBlogin db;//정적으로 'db'테이블 생성
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db= Room.databaseBuilder(this,DBlogin.class,"dbtest")
                .allowMainThreadQueries().build();
        final EditText idText= (EditText) findViewById(R.id.input_id);
        final EditText pwdText= (EditText) findViewById(R.id.input_pwd);

        findViewById(R.id.loginbutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder bulider=new AlertDialog.Builder(Login.this);
                bulider.setMessage("try").create().show();
                if(db.userDao().loginApp(idText.getText().toString(),pwdText.getText().toString())!=null)
                {

                    Intent mainintent=new Intent(Login.this, Menu_MainActivity.class);
                   mainintent.putExtra("userID",idText.getText().toString());

                    Login.this.startActivity(mainintent);
                }
                else
                    bulider.setMessage("fail!").setNegativeButton("ok",null).create().show();
            }
        });
        TextView registerButton=(TextView)findViewById(R.id.registerbutton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent =new Intent(Login.this, registerAct.class);

                Login.this.startActivity(registerIntent);
            }
        });
    }
}
