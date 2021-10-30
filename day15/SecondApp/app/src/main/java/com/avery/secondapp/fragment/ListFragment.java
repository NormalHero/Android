package com.avery.secondapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.avery.secondapp.R;

import java.util.ArrayList;


public class ListFragment extends Fragment {
    TextView etInput;
    Button btnAdd, btnEdit, btnDel;
    ListView lvData;

    ArrayList<String> listMember;
    ArrayAdapter adapter;


    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);


        etInput = view.findViewById(R.id.etName);
        lvData = view.findViewById(R.id.lvMember);

        listMember = new ArrayList<>();
        listMember.add("Hello");
        listMember.add("My");
        listMember.add("Giid");

        // adapter = new ArrayAdapter(ListActivity.this, android.R.layout.simple_list_item_1, listMember);
        adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_single_choice, listMember);
        // 어댑터
        lvData.setAdapter(adapter);






        btnAdd = view.findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listMember.add(etInput.getText().toString());
                adapter.notifyDataSetChanged();

            }
        });

/*
        // 몇번째 아이템이 선택 되었는지 확인
        int i = lvData.getCheckedItemPosition();

        // 2. choice 초기화
        lvData.clearChoices();

        // 3. ArrayList 특정 인덱스 값을 변경 .set(index, 값);
        //              특정 인덱스 값을 삭제 .remove(index)

*/
        btnDel = view.findViewById(R.id.btnDel);
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index = lvData.getCheckedItemPosition();


                if(index<0){
                    Toast.makeText(getActivity(), "선택된 값이 없음", Toast.LENGTH_SHORT).show();
                }else{
                    listMember.remove(index);
                    lvData.clearChoices();
                    adapter.notifyDataSetChanged();
                }

            }
        });


        btnEdit = view.findViewById(R.id.btnEdit);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index = lvData.getCheckedItemPosition();

                // adapter.set
                if(index<0){
                    Toast.makeText(getActivity(), "선택된 값이 없음", Toast.LENGTH_SHORT).show();
                }else{
                    listMember.set(index, etInput.getText().toString());
                    lvData.clearChoices();
                    adapter.notifyDataSetChanged();
                }
            }
        });



        lvData.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String item = listMember.get(position);
                Toast.makeText(getActivity(), position + " : " + item, Toast.LENGTH_SHORT).show();
            }
        });






        return view;
    }
}