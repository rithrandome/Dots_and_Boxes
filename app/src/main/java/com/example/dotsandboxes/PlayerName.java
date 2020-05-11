package com.example.dotsandboxes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.String;

public class PlayerName extends AppCompatActivity {

    Button b1,b2;
    EditText p1,p2,d1,d2;
    String player1,player2;
    TextView t,t2,t3,t4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_name);

        b1 = findViewById(R.id.button);
        p1 = findViewById(R.id.player_1);
        p2 = findViewById(R.id.player_2);
        d1 = findViewById(R.id.editText);
        d2 = findViewById(R.id.editText2);
        b2 = findViewById(R.id.button2);
        t = findViewById(R.id.textView);
        t2 = findViewById(R.id.textView2);
        t3 = findViewById(R.id.textView3);
        t4 = findViewById(R.id.textView4);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(p1.getText()) && TextUtils.isEmpty(p2.getText())){
                    p1.setError("Enter 1st Player Name !!");
                    p2.setError("Enter 2nd Player Name !!");
                } else if (TextUtils.isEmpty(p2.getText())) {
                    p2.setError("Enter 2nd Player Name !!");
                }
                else if(TextUtils.isEmpty(p1.getText())){
                    p1.setError("Enter 1st Player Name !!");
                }
                else {
                    player1 = p1.getText().toString().toUpperCase();
                    player2 = p2.getText().toString().toUpperCase();

                    t.setVisibility(View.VISIBLE);
                    t3.setVisibility(View.GONE);
                    t2.setVisibility(View.VISIBLE);
                    t4.setVisibility(View.GONE);
                    p1.setVisibility(View.GONE);
                    p2.setVisibility(View.GONE);
                    b1.setVisibility(View.GONE);
                    b2.setVisibility(View.VISIBLE);
                    d1.setVisibility(View.VISIBLE);
                    d2.setVisibility(View.VISIBLE);
                }

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(d1.getText()) && TextUtils.isEmpty(d2.getText())){
                    d1.setError("Enter dimension!!");
                    d2.setError("Enter dimension!!");
                } else if (TextUtils.isEmpty(d2.getText())) {
                    d2.setError("Enter dimension!!");
                }
                else if(TextUtils.isEmpty(d1.getText())){
                    d1.setError("Enter dimension!!");
                }
                else {

                    Intent intent = new Intent(PlayerName.this, Game.class);
                    intent.putExtra("player_1",player1.charAt(0));
                    intent.putExtra("player_2",player2.charAt(0));
                    intent.putExtra("rows",Integer.parseInt(d1.getText().toString()));
                    intent.putExtra("columns",Integer.parseInt(d2.getText().toString()));
                    startActivity(intent);

                }

            }
        });
    }
}
