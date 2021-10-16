package com.avery.secondapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.avery.secondapp.fragment.HomeFragment;
import com.avery.secondapp.fragment.ListFragment;
import com.avery.secondapp.fragment.PostFragment;
import com.google.android.material.tabs.TabLayout;

public class TabActivity extends AppCompatActivity {

    TabLayout tabLayout;
    FragmentManager fm;
    FragmentTransaction ft;

    PostFragment postFragment = new PostFragment();
    HomeFragment homeFragment = new HomeFragment();
    ListFragment listFragment = new ListFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);






        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.add(R.id.flMain, postFragment);
        ft.commit();

        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                if(tab.getPosition() == 0){
                    ft = fm.beginTransaction();
                    ft.replace(R.id.flMain, postFragment);
                    ft.commit();
                }else if(tab.getPosition() == 1){
                    ft = fm.beginTransaction();
                    ft.replace(R.id.flMain, homeFragment);
                    ft.commit();

                }else if(tab.getPosition() == 2){
                    ft = fm.beginTransaction();
                    ft.replace(R.id.flMain, listFragment);
                    ft.commit();
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }





}