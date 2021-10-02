package com.avery.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final String ID ="admin";
    final String PW ="1234";
    TextView etID,etPW ;
    Button btnLogin,btnList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("### MainAcTivity ###","onCreate called!");




        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                etID = findViewById(R.id.etID);
                etPW = findViewById(R.id.etPW);
                String UserId = etID.getText().toString();
                String UserPw = etPW.getText().toString();
                System.out.println(UserId+" - "+UserPw);
                System.out.println("dadadada");

                if (ID.equals(UserId) && PW.equals(UserPw)) {


                 //  Intent intent = new Intent(MainActivity.this, PostActivity.class); // 명시적 인텐트

                  //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.naver.com/")); // 암시적 인텐트
                  //  Intent intent = new Intent(Settings.ACTION_SOUND_SETTINGS);

                    Intent intent = new Intent(MainActivity.this, PostActivity.class);
                    intent.putExtra("ID", UserId);
                    intent.putExtra("PW", UserPw);

                 // int num = Integer.parseInt(UserPw);
                 //  intent.putExtra("num", num);
                    startActivity(intent);

                    finish(); // 종료시켜놓고 넘어감으로써 앱구동 시나리오상 적절하게 사용한다.
                } else {
                    Toast.makeText(MainActivity.this, "로그인에 실패하였습니다!", Toast.LENGTH_SHORT).show();
                }
            }

        });

        btnList = findViewById(R.id.btnList);
        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });




    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("### MainAcTivity ###","onStart called!");


    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("### MainAcTivity ###","onResume called!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("### MainAcTivity ###","onPause called!");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("### MainAcTivity ###","onStop called!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("### MainAcTivity ###","onDestroy called!");
    }



}