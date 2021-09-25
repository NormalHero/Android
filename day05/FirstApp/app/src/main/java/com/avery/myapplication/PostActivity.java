package com.avery.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PostActivity extends AppCompatActivity {

    Button btnzza,btnzzam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        btnzza = findViewById(R.id.btnzza);
        btnzzam= findViewById(R.id.btnzzam);

        btnzza.setOnClickListener(new View.OnClickListener() {
            AlertDialog.Builder builder = new AlertDialog.Builder(PostActivity.this);
            @Override
            public void onClick(View view) {
                Toast.makeText(PostActivity.this, "짜장면을 선택하셨습니다!",Toast.LENGTH_SHORT).show();
            }
        });

        btnzzam.setOnClickListener(new View.OnClickListener() {
            AlertDialog.Builder builder = new AlertDialog.Builder(PostActivity.this);
            @Override
            public void onClick(View view) {
                Toast.makeText(PostActivity.this, "짬뽕을 선택하셨습니다!",Toast.LENGTH_SHORT).show();
            }
        });

    }
}