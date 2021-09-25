package com.avery.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final String ID ="admin";
    final String PW ="1234";
    TextView etID,etPW ;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






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


                    Intent intent = new Intent(MainActivity.this, PostActivity.class);
                    startActivity(intent);
                    finish(); // 종료시켜놓고 넘어감으로써 앱구동 시나리오상 적절하게 사용한다.
                } else {
                    Toast.makeText(MainActivity.this, "로그인에 실패하였습니다!", Toast.LENGTH_SHORT).show();
                }
            }

        });




    }


}