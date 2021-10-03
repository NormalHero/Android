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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.avery.myapplication.adapter.MemberAdapter;
import com.avery.myapplication.adapter.MemberRecycleAdapter;
import com.avery.myapplication.data.Member;

import java.util.ArrayList;

public class RecycleActivity extends AppCompatActivity {

    EditText etName, etAge;
    Button btnAdd;
    RecyclerView rvMember;
    MemberRecycleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);

        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        btnAdd = findViewById(R.id.btnAdd2);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String age = etAge.getText().toString();

                adapter.addItem(new Member(name, age));

            }
        });

        rvMember = findViewById(R.id.rvMember);
        adapter = new MemberRecycleAdapter(RecycleActivity.this);
        rvMember.setAdapter(adapter);

        LinearLayoutManager lManager = new LinearLayoutManager(RecycleActivity.this);
        lManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        GridLayoutManager gManger = new GridLayoutManager(RecycleActivity.this, 3);

        rvMember.setLayoutManager(gManger);
    }
}