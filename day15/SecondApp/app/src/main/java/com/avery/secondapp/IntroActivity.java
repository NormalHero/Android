package com.avery.secondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class IntroActivity extends AppCompatActivity {
    Button btnHome, btnDrawer,btnTAB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        btnHome = findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntroActivity.this, HomeActivity.class);
                startActivity(intent);

            }
        });

        btnDrawer = findViewById(R.id.btnDrawer);
        btnDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntroActivity.this, DrawerActivity.class);
                startActivity(intent);
            }
        });

        btnTAB= findViewById(R.id.btnTAB);
        btnTAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntroActivity.this, TabActivity.class);
                startActivity(intent);
            }
        });


        Uri uri = Uri.parse("content://com.avery.thirdapp.data");
        Bundle data = getContentResolver().call(uri, "",null,null);

        Toast.makeText(this,"name: "+ data.getString("name")+
                " age: "+ data.getString("age"), Toast.LENGTH_SHORT).show();

    }
}