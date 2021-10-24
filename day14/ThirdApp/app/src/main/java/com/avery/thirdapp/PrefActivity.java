package com.avery.thirdapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PrefActivity extends AppCompatActivity {
    Button btnSave, btnLoad;
    TextView tvId, tvPw, tvAge, tvName;
    EditText etId, etPw, etAge, etName;

    SharedPreferences mPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pref);

        etId = findViewById(R.id.etId);
        etPw = findViewById(R.id.etPw);
        etAge = findViewById(R.id.etAge);
        etName = findViewById(R.id.etName);

        btnSave = findViewById(R.id.btnSave);
        btnLoad = findViewById(R.id.btnLoad);

        mPref = getSharedPreferences("LoginInfo",MODE_PRIVATE);
        etName.setText(mPref.getString("name","-"));

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mPref.edit(); // 데이터를 쓸 준비를 끝냄
                editor.putString("name", etName.getText().toString());
                editor.putString("pw", etPw.getText().toString());
                editor.putInt("age",Integer.parseInt(etAge.getText().toString()));
                editor.putString("id", etId.getText().toString());
                // 다른 데이터들도 받을수 있게 구현
                editor.apply();
            }
        });

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etName.setText(mPref.getString("name","-"));
                etPw.setText(mPref.getString("pw","-"));
                etId.setText(mPref.getString("id","-"));
                etAge.setText(String.valueOf(mPref.getInt("age",0)));
                //etAge.setText(""+mPref.getInt("age",0));
            }
        });
    }
}