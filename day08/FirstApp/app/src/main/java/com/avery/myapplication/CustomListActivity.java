package com.avery.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.avery.myapplication.adapter.MemberAdapter;
import com.avery.myapplication.data.Member;

import java.util.ArrayList;

public class CustomListActivity extends AppCompatActivity {

    EditText etName, etAge;
    Button btnAdd2;
    ListView lvMember;


    MemberAdapter adapter;


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);

        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        btnAdd2 = findViewById(R.id.btnAdd2);

        lvMember = findViewById(R.id.lvMember);
        adapter = new MemberAdapter(CustomListActivity.this);
        lvMember.setAdapter(adapter);

        btnAdd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                String age = etAge.getText().toString();

                adapter.addItem(new Member(name, age));

            }
        });









/*


*/











    }





}
