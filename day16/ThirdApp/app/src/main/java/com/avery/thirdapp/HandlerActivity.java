package com.avery.thirdapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;


public class HandlerActivity extends AppCompatActivity {

    public static  final int SEND_INFO = 0;

    TextView tvTime;
    Button btnStart, btnStop;
    int count = 0;
    TestThread testThread = new TestThread();


    Handler mHandler = new Handler(Looper.getMainLooper()){

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);



            if(msg.what == SEND_INFO){
                String data = (String)msg.obj;
                tvTime.setText(data);
            }
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        testThread.start();

        tvTime = findViewById(R.id.tvTime);
//        mHandler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                tvTime.setText("1초 뒤에 실행 됬음");
//
//            }
//        }, 1000);



       // setTimer();

        btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              testThread.changeStatus(true);
            }
        });


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

    class TestThread extends Thread{

        boolean isRunning = true; // Thread 동작 여부
        int count = 0;


        void changeStatus(boolean isRunning){
            this.isRunning = !this.isRunning;
        }

        @Override
        public void run() {
            super.run();

            while (isRunning){

                count++;

                Message msg = mHandler.obtainMessage();
                msg.what = SEND_INFO;                   // Message 구분값
                msg.obj = " - " +count + " - ";         // 실제 Message Data

                mHandler.sendMessage(msg);
              //  mHandler.sendEmptyMessage(SEND_INFO);




                tvTime.setText(" - "+ count);

                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }


        }



    }

}