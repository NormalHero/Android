package com.avery.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.avery.myapplication.R;
import com.avery.myapplication.data.Member;

import java.util.ArrayList;

public class MemberAdapter extends BaseAdapter {

    ArrayList<Member> listMember = new ArrayList<>();
    Context nContext; // 멤버변수임을 강조하기위해 n을 사용
    MemberViewHolder holder;

    public class MemberViewHolder{
        TextView tvName;
        TextView tvAge;
        ImageView imgProfile;
    }

    public MemberAdapter(Context nContext) {
        this.nContext = nContext;


    }

    @Override
    public int getCount() {
        return listMember.size();
    }

    @Override
    public Object getItem(int position) {
        return listMember.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
              // listview에서 몇번째그리는지..

     // infalte : xml에서 표기된 레이아웃들을 메모리에 객체화 시키는 행동
    // Activity로 치면 setContentView()


        // ==============  홀더 패턴 시작
        if(convertView == null) {
            convertView = LayoutInflater.from(nContext).inflate(R.layout.lv_member_item, parent, false); // Activity에서 setContentView의 역할
            holder = new MemberViewHolder();

            holder.tvName = convertView.findViewById(R.id.tvItemName);
            holder.tvAge = convertView.findViewById(R.id.tvItemAge);
            holder.imgProfile = convertView.findViewById(R.id.imgItemProfile);
            convertView.setTag(holder); //데이터를 잠깐 저장해 두었다가 획득해 사용해야할 때 유용하게 사용할 수 있는 방법
        }else{
            holder =(MemberViewHolder) convertView.getTag();
        }
        holder.tvName.setText(listMember.get(position).getName());
        holder.tvAge .setText(listMember.get(position).getAge());


            if(position % 2 ==1){

                holder.imgProfile .setImageResource(R.drawable.kakao);
            }






        return convertView;
    }

    public void addItem(Member member){
        listMember.add(member);
        notifyDataSetChanged(); // 어댑터 안에 사용하기 때문에 바로 사용가능하다.
    }

}
