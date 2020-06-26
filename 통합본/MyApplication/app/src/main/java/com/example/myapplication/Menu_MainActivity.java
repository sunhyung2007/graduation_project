package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class Menu_MainActivity extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity_main);
        tv=(TextView)findViewById(R.id.textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.checklistItem:
                Intent intent = new Intent(getApplicationContext(), CheckList_MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.generalboardItem:
                intent = new Intent(getApplicationContext(), Board_MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.boxItem:
                intent = new Intent(getApplicationContext(), Box.class);
                startActivity(intent);
                return true;
            case R.id.mysettingItem:
                tv.setText("개인의 정보를 확인합니다.");
                return true;
        }

        return false;
    }
}