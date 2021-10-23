package com.avery.thirdapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;


public class HandlerActivity extends AppCompatActivity {
    TextView tvTime;
    int count = 0;
    Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        tvTime = findViewById(R.id.tvTime);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                tvTime.setText("1초 뒤에 실행 됬음");

            }
        }, 1000);



       // setTimer();

    }


    void setTimer(){
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                    count++;
                   // tvTime.setText("-"+count+"-");
                // 1. view 위젯에 post 호출
//                tvTime.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        tvTime.setText(" - "+count+" - ");
//                    }
//                });


                //2. runOnUiThread 사용
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        tvTime.setText(" - "+count+" - ");
//                    }
//                });

                //3. Handler
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        tvTime.setText(" - "+count+" - ");
                    }
                });

            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 0, 1000);

    }
}