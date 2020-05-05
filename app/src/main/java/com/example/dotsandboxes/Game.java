package com.example.dotsandboxes;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

public class Game extends AppCompatActivity {

    private dots_and_boxes db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new dots_and_boxes(this);
        db.setBackgroundResource(R.drawable.orangishyellow_background);
        setContentView(db);
    }
}
