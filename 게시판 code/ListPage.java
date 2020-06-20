package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ListPage extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_itemview);

        String title = getIntent().getStringExtra("titleContext");
        TextView titleView = (TextView) this.findViewById(R.id.Board_titleContext);
        String writer = getIntent().getStringExtra("writerContext");
        TextView writerView = (TextView) this.findViewById(R.id.Board_writerContext);
        String desc = getIntent().getStringExtra("descContext");
        TextView descView = (TextView) this.findViewById(R.id.Board_descContext);

        titleView.setText(title);
        writerView.setText(writer);
        descView.setText(desc);

    }
}