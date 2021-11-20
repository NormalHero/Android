package com.avery.fourthapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.avery.fourthapp.Manager.NotifiManager;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);


        findViewById(R.id.btnShowNoti).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                NotifiManager.showNotification(NotificationActivity.this, "제목제목", "내용내용");

                NotifiManager.showNotification(NotificationActivity.this);
            }
        });
        findViewById(R.id.btnCanceNoti).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.cancel(5555);
            }
        });

        IntentFilter filter = new IntentFilter();
        filter.addAction(NotifiManager.NOTI_CLICK_ACTION);


        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                Toast.makeText(NotificationActivity.this, "Action : " + intent.getAction(), Toast.LENGTH_SHORT).show();

            }
        };

        registerReceiver(broadcastReceiver, filter);




    }



    }

//    void showNotification(){
//
//
//
//        NotificationManager notificationManager =(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//
//        NotificationCompat.Builder builder =new NotificationCompat.Builder(NotificationActivity.this, "1004")
//                .setContentTitle("제목")
////                .setStyle(new NotificationCompat.BigTextStyle().bigText("세부 내용  \n 세부 내용  세부 내용 \n 세부 내용 \n 세부 내용 \n 세부 내용 \n 세부  내용세부 내용"))
////                .setContextText("내용 내용");
//                .setOngoing(true)
//                .setStyle(new NotificationCompat.BigTextStyle().bigText("세부 내용  \n 세부 내용  세부 내용 \n 세부 내용 \n 세부 내용 \n 세부 내용 \n 세부  내용세부 내용"));
//
////                .setAutoCancel(true);
//
//        Intent intent = new Intent(NotificationActivity.this, MusicActivity.class);
//        PendingIntent pendingIntent = PendingIntent.getActivity(NotificationActivity.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//        // 누르는 시점에 실행되기 위해 사용
//
//        builder.setContentIntent(pendingIntent);
//
//
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
//            builder.setSmallIcon((R.drawable.ic_launcher_foreground));
//
//            NotificationChannel channel = new NotificationChannel("1004","테스트 체널", NotificationManager.IMPORTANCE_HIGH);
//            channel.setDescription(" 설명 설명");
//
//            notificationManager.createNotificationChannel(channel);
//        }else{
//            builder.setSmallIcon(R.mipmap.ic_launcher);
//            // 오레오 이하 버전에서는 mipmap으로 하게 되어있음
//        }
//        Notification notification = builder.build();
//
//        notificationManager.notify(5555, notification);
//       // notificationManager.notify((int)System.currentTimeMillis(), notification);
//
//    }
