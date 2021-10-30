package com.avery.secondapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.avery.secondapp.adapter.PagerAdapter;
import com.avery.secondapp.fragment.HomeFragment;
import com.avery.secondapp.fragment.ListFragment;
import com.avery.secondapp.fragment.PostFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class TabActivity extends AppCompatActivity {

    TabLayout tabLayout;
    FragmentManager fm;
    FragmentTransaction ft;

    PostFragment postFragment = new PostFragment();
    HomeFragment homeFragment = new HomeFragment();
    ListFragment listFragment = new ListFragment();

    ViewPager2 viewPager ;
    PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        setTabLayoutWithPager();





    }

    void setTabLayoutWithPager(){

        viewPager = findViewById(R.id.viewPager);
        pagerAdapter = new PagerAdapter(this);
        pagerAdapter.addFragment(postFragment);
        pagerAdapter.addFragment(homeFragment);
        pagerAdapter.addFragment(listFragment);
        viewPager.setAdapter(pagerAdapter);

        tabLayout = findViewById(R.id.tabLayout);
        String[] arrTabTitle = {"POST","HOME","LIST"};
        int[] arrTabIcon = {R.drawable.ic_post, R.drawable.ic_home, R.drawable.ic_list};

        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(arrTabTitle[position]);
                tab.setIcon(arrTabIcon[position]);
            }
        }).attach();

    }

    void setDefaultTabLayout(){

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