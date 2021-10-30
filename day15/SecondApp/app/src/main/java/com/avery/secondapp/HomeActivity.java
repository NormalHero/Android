package com.avery.secondapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.avery.secondapp.fragment.HomeFragment;
import com.avery.secondapp.fragment.ListFragment;
import com.avery.secondapp.fragment.PostFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends AppCompatActivity {
    Button btnAct;
    EditText etAct;




    int selectedFragment = 0; // 0 : Post, 1  : Home , 2: List

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    BottomNavigationView bottomNavi;
    Toolbar toolbar;

    ListFragment listFragment;
    PostFragment postFragment;
    HomeFragment homeFragment;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.mi_post){
            Toast.makeText(HomeActivity.this, " Post! Clicked", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

       // getSupportActionBar().setDisplayShowTitleEnabled(false);


        etAct = findViewById(R.id.etAct);
        btnAct = findViewById(R.id.btnAct);
        btnAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedFragment == 1)
                homeFragment.setText(etAct.getText().toString());
            }
        });

        listFragment = new ListFragment();
        postFragment = new PostFragment();
        homeFragment = new HomeFragment();


        fragmentManager = getSupportFragmentManager();



        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fl_home, postFragment);
        fragmentTransaction.commit();



        bottomNavi = findViewById(R.id.bottomNavi);
        bottomNavi.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId() == R.id.mi_post){
                    if(selectedFragment != 0){

                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fl_home, postFragment); // 변경은 replace
                        fragmentTransaction.commit();
                        selectedFragment = 0;


                    }
                    return true;

                }else if(item.getItemId() == R.id.mi_home){
                    if(selectedFragment != 1){
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fl_home, homeFragment); // 변경은 replace
                        fragmentTransaction.commit();
                        selectedFragment = 1;
                    }
                    return true;
                }else if(item.getItemId() == R.id.mi_list){

                    if(selectedFragment != 2){
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fl_home, listFragment); // 변경은 replace
                        fragmentTransaction.commit();
                        selectedFragment = 2;
                    }
                    return true;
                }




                return false;
            }
        });

        homeFragment.setOnchangeListener(new HomeFragment.onChangeListener() {
            @Override
            public void onChanged(String text) {
                etAct.setText(text);
            }
        });
















    }
}