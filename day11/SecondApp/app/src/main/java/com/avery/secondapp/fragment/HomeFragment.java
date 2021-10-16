package com.avery.secondapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.avery.secondapp.R;



public class HomeFragment extends Fragment {


    public interface onChangeListener{
        void onChanged(String text);
    }



    Button btnFrag;
    EditText etFrag;
    onChangeListener changeListener;

    public HomeFragment() {

    }

    public void setText(String input){
        etFrag.setText(input);

    }

    public  void setOnchangeListener(onChangeListener listener){
        this.changeListener = listener;
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


                View view =  inflater.inflate(R.layout.fragment_home, container, false);
                etFrag = view.findViewById(R.id.etFrag);

                btnFrag = view.findViewById(R.id.btnFrag);
                btnFrag.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        changeListener.onChanged(etFrag.getText().toString());
                    }
                });

                return view;
    }
}