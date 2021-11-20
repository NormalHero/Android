package com.avery.fourthapp.Manager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.avery.fourthapp.receiver.AlarmReceiver;

public class AManager {
    public  static void registerAlarm(Context context){

        Intent intent = new Intent(context, AlarmReceiver.class);
        intent.setAction("com.avery.fourthapp.ALARM");
        intent.putExtra("id",111);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,111,intent,PendingIntent.FLAG_UPDATE_CURRENT);   //팬딩 인텐트

        AlarmManager alarmManager =(AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(pendingIntent);

        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+5000,pendingIntent); // 화면 잠금시에도 가능하게


    }
}
