package com.avery.thirdapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class NetworkActivity extends AppCompatActivity {



    TextView tvResult;
    ListView lvJSON;
    Button btnGet;

    ArrayList<String> listMember;
    ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);


        tvResult = findViewById(R.id.tvResult);
        lvJSON = findViewById(R.id.lvJSON);

        listMember = new ArrayList<>();



        btnGet = findViewById(R.id.btnGet);

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new HttpTread().start();

            }
        });




    }

    class HttpTread extends  Thread{

        @Override
        public void run() {
            super.run();

            String address = "https://jsonplaceholder.typicode.com/posts";
            String resultData = "";

            try {
                URL url = new URL(address);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                connection.setRequestMethod("GET");
                connection.setRequestProperty("Accept","application/json");
                connection.setRequestProperty("content-Type","application/json");

                connection.connect();

                int code = connection.getResponseCode();

                if(code == 200){

                    InputStream response = connection.getInputStream();
                    InputStreamReader isr = new InputStreamReader(response);
                    BufferedReader reader = new BufferedReader(isr);

                    StringBuffer sb = new StringBuffer();
                    String line;

                    while ((line = reader.readLine()) != null){

                        sb.append(line);


                    }
                    resultData = sb.toString();

                    response.close();
                    reader.close();


                }else{
                    resultData = "Error!!";
                }
                connection.disconnect();

            }catch (Exception e){

                resultData = "Exception!!";

            }

          //  String finalResultData = (resultData);
            String finalResultData = parsJSON(resultData);

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
             //       tvResult.setText(finalResultData);
                    adapter = new ArrayAdapter( NetworkActivity.this, android.R.layout.simple_list_item_1, listMember);

                    lvJSON.setAdapter(adapter);
                }
            });



        }



        String parsJSON(String in){
            String out = "";

            JSONArray jsonArray = null;
            JSONObject jsonObject = null;

            try {

                jsonArray = new JSONArray(in);
                for (int i = 0 ; i < jsonArray.length(); i++){
                    jsonObject = (JSONObject) jsonArray.get(i);
                    // out = jsonObject.getString("title");
                    listMember.add(jsonObject.getString("title"));
                }

            }catch (JSONException e){

            }

            return out;
        }





//        void listJSON(String in){
//
//            listMember = new ArrayList<>();
//
//            JSONArray jsonArray = null;
//            JSONObject jsonObject = null;
//
//            try {
//
//                jsonArray = new JSONArray(in);
//                int cnt = 0;
//                while(jsonObject.keys().hasNext()) {
//                    jsonObject = (JSONObject) jsonArray.get(cnt);
//                    listMember.add(jsonObject.getString("title"));
//                    cnt++;
//                }
//                adapter.notifyDataSetChanged();
//
//               // int id = jsonObject.getInt("id");
//
//            }catch (JSONException e){
//
//            }
//
//
//
//
//        }


    }
}