package com.avery.secondapp.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.avery.secondapp.HomeActivity;
import com.avery.secondapp.R;

public class PostFragment extends Fragment {



    TextView tvName, tvLocation;

    public PostFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post, container, false);
        Button btnzza = view.findViewById(R.id.btnzza);
        Button btnzzam = view.findViewById(R.id.btnzzam);

        btnzza.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "짜장면을 선택하셨습니다!",Toast.LENGTH_SHORT).show();
            }
        });

        btnzzam.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "짬뽕을 선택하셨습니다!",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}