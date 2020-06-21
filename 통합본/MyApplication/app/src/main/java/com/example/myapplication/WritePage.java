package com.example.myapplication;

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

        final EditText editTitleText = findViewById(R.id.editTitle);
        final EditText editWriterText = findViewById(R.id.editWriter);
        final EditText editDescText = findViewById(R.id.editDesc);

        final ListAppDatabase db = Room.databaseBuilder(this, ListAppDatabase.class, "ListDatabase-db").allowMainThreadQueries().build();

        Button BoardFinishButton = (Button)findViewById(R.id.finishButton);
        BoardFinishButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (editTitleText.getText().toString().matches("") || editWriterText.getText().toString().matches("") || editDescText.getText().toString().matches(""))
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(WritePage.this);
                    builder.setMessage("빈공간을 채워주세요");
                    builder.setPositiveButton("OK", null);
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
                else {
                    db.listDatabaseDao().insert(new ListDatabase(editTitleText.getText().toString(), editWriterText.getText().toString(), editDescText.getText().toString()));
                    Intent intent = new Intent(getApplicationContext(), Board_MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
