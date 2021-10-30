package com.avery.secondapp.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class PagerAdapter extends FragmentStateAdapter {

    ArrayList<Fragment> listFragment = new ArrayList<>();

    public PagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getItemCount() {
        return listFragment.size();
    }

    public void addFragment(Fragment fragment){
        listFragment.add(fragment);
        // 값 변화, 수정 추가 등이 생겼을때는 notifydatachanged를 작성
    }
}
