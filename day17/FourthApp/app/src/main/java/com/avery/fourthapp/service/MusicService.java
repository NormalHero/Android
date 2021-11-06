package com.avery.fourthapp.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import com.avery.fourthapp.R;

public class MusicService extends Service {
    MediaPlayer mediaPlayer;
    public MusicService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d("Music Service", " onCreate" );
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.



        Log.d("Music Service"," onBind ");

        mediaPlayer = MediaPlayer.create(this, R.raw.test);
        mediaPlayer.start();

        return new Binder();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
    // 바인드를 사용할 때는 스킵된다
        Log.d("Music Service", "onStartCommand");

        mediaPlayer = MediaPlayer.create(this, R.raw.test);
        mediaPlayer.start();





        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {

        Log.d("Music Service", " onDestroy");

        // 사용하고 있는 리소스를 해제해준다
        mediaPlayer.stop();
        mediaPlayer.release();

        super.onDestroy();
    }
}