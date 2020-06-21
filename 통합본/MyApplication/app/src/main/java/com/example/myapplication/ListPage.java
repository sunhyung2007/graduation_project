package com.example.myapplication;

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