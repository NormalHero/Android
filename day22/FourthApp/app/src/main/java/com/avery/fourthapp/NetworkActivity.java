package com.avery.fourthapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.avery.fourthapp.adapter.MemberRecycleAdapter;
import com.avery.fourthapp.api.APIClient;
import com.avery.fourthapp.api.MemberAPI;
import com.avery.fourthapp.data.Member;
import com.avery.fourthapp.helper.MyDBHelper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class NetworkActivity extends AppCompatActivity {
    Retrofit retrofit = APIClient.getClient();
    MemberAPI memberAPI = retrofit.create(MemberAPI.class);
    RecyclerView rvMember;
    MemberRecycleAdapter adapter;


    String loginid, setpassword, name;
    EditText etId, etPW, etName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);



        etId = findViewById(R.id.etId);
        etPW = findViewById(R.id.etPW);
        etName = findViewById(R.id.etName);

        rvMember = findViewById(R.id.rvMember);


        findViewById(R.id.btnRegist).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginid = etId.getText().toString();
                setpassword = etPW.getText().toString();
                name = etName.getText().toString();
                regist(loginid, setpassword, name);
            }
        });
        findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginid = etId.getText().toString();
                setpassword = etPW.getText().toString();
                login(loginid,setpassword);
            }
        });
        findViewById(R.id.btnGetList).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter = new MemberRecycleAdapter(NetworkActivity.this);
                rvMember.setAdapter(adapter);
                LinearLayoutManager lManger = new LinearLayoutManager(NetworkActivity.this);
                rvMember.setLayoutManager(lManger);

                getMemberList();
            }
        });

    }


    void regist(String loginid, String setpassword,String name ){




        Member member = new Member();
        member.setLoginId(loginid);
        member.setPassword(setpassword);
        member.setName(name);
        member.setType(4);

        memberAPI.regist(member).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.code()==200){
                    Toast.makeText(NetworkActivity.this, "회원가입 성공",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }

    void login(String loginid, String setpassword){
        Member member = new Member();
        member.setLoginId(loginid);
        member.setPassword(setpassword);
        member.setType(4);

        memberAPI.login(member).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.code() == 200){
                    Toast.makeText(NetworkActivity.this, "로그인 성공",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(NetworkActivity.this, "로그인 실패",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(NetworkActivity.this, "통신 오류",Toast.LENGTH_SHORT).show();
            }
        });

    }

    void getMemberList(){

        memberAPI.getMemberList(4).enqueue(new Callback<List<Member>>() {
            @Override
            public void onResponse(Call<List<Member>> call, Response<List<Member>> response) {
                if(response.code() == 200){
                    List<Member> list = response.body();

                    for (int i = 0; i < list.size(); i++){
                        Log.d("### Member List ###", i+" : "+ list.get(i));
                        adapter.addItem(new Member(list.get(i).getLoginId(), list.get(i).getName()));

                    }
                }
            }

            @Override
            public void onFailure(Call<List<Member>> call, Throwable t) {

            }
        });

    }
}