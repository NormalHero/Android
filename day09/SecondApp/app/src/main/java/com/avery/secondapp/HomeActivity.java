package com.avery.secondapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.avery.secondapp.fragment.ListFragment;
import com.avery.secondapp.fragment.PostFragment;

public class HomeActivity extends AppCompatActivity {
    Button btnPost,btnList;




    int selectedFragment = 0; // 0 : Post, 1  : List

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    ListFragment listFragment;
    PostFragment postFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        listFragment = new ListFragment();
        postFragment = new PostFragment();

        fragmentManager = getSupportFragmentManager();



        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fl_home, postFragment);
        fragmentTransaction.commit();




        btnPost = findViewById(R.id.btnPost);
        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(selectedFragment == 1){

                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fl_home, postFragment); // 변경은 replace
                    fragmentTransaction.commit();
                    selectedFragment = 0;

                }

            }
        });

        btnList = findViewById(R.id.btnList);
        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if(selectedFragment == 0){
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fl_home, listFragment); // 변경은 replace
                    fragmentTransaction.commit();
                    selectedFragment = 1;
                }

            }
        });









    }
}