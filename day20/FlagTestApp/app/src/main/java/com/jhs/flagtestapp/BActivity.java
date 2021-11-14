package com.jhs.flagtestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        TextView tvMain = findViewById(R.id.tvMain);
        tvMain.setText("B");

        findViewById(R.id.btnMain).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(BActivity.this, MainActivity.class);
                intent.addFlags(Constant.FLAG);
                startActivity(intent);

            }
        });

        findViewById(R.id.btnA).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(BActivity.this, AActivity.class);
                intent.addFlags(Constant.FLAG);
                startActivity(intent);

            }
        });

        findViewById(R.id.btnB).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(BActivity.this, BActivity.class);
                intent.addFlags(Constant.FLAG);
                startActivity(intent);

            }
        });

        findViewById(R.id.btnC).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(BActivity.this, CActivity.class);
                intent.addFlags(Constant.FLAG);
                startActivity(intent);

            }
        });
    }
}