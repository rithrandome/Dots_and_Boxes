package com.example.dotsandboxes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Game extends AppCompatActivity {

    private dots_and_boxes db;
    int r,c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new dots_and_boxes(this);
        db.setBackgroundResource(R.drawable.background);

        Intent intent = getIntent();
        r = intent.getIntExtra("rows",0);
        c = intent.getIntExtra("columns",0);

        db.setNumColumns(c);
        db.setNumRows(r);

        setContentView(db);

    }
}
