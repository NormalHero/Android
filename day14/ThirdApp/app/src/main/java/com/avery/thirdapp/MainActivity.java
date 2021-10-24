package com.avery.thirdapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnPref, btnHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnPref = findViewById(R.id.btnPref);
        btnPref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PrefActivity.class);
                startActivity(intent);
            }
        });

        btnHandler= findViewById(R.id.btnHandler);
        btnHandler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HandlerActivity.class);
                startActivity(intent);
            }
        });

        if(checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){

            String[] permission ={Manifest.permission.CAMERA};
            requestPermissions(permission, 1004); // 1004 리퀘스트 코드





        }

        findViewById(R.id.btnNetwork).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NetworkActivity.class);
                startActivity(intent);
            }
        });



    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == 1004){
            if(grantResults.length > 0){

                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(MainActivity.this, " 권한 획득 성공 !! ", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, " 권한 획득 실패 !! ", Toast.LENGTH_SHORT).show();
                }

            }

        }


    }
}