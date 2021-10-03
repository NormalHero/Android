package com.avery.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.avery.myapplication.R;
import com.avery.myapplication.RecycleActivity;
import com.avery.myapplication.data.Member;

import java.util.ArrayList;

public class MemberRecycleAdapter extends RecyclerView.Adapter<MemberRecycleAdapter.MemberHolder> {


    ArrayList<Member> listMember = new ArrayList<>();
    Context mContext;

    public class MemberHolder extends RecyclerView.ViewHolder{

        TextView tvName;
        TextView tvAge;
        ImageView imgProfile;

        public MemberHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvItemName);
            tvAge = itemView.findViewById(R.id.tvItemAge);
            imgProfile = itemView.findViewById(R.id.imgItemProfile);
        }
    }

    public MemberRecycleAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MemberHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.lv_member_item, parent, false);
        MemberHolder holder = new MemberHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MemberHolder holder, int position) {

        holder.tvName.setText(listMember.get(position).getName());
        holder.tvAge.setText(listMember.get(position).getAge());

        if (position % 2 == 1) {

            holder.imgProfile.setImageResource(R.drawable.kakao);
        }
    }

    @Override
    public int getItemCount() {
        return listMember.size();
    }

    public void addItem(Member member){

        listMember.add(member);
        notifyDataSetChanged();
    }


}
