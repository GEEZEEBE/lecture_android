package com.advanced_android.musicplayersample;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;

public class StartServiceActivity extends AppCompatActivity {

    private Boolean mIsPlaying;
    private View mBtnPlay;
    private View mBtnStop;
    private BackgroundMusicService mServiceBinder;
    // 서비스와의 연결 콜백
    private ServiceConnection myConnection = new ServiceConnection() {

        public void onServiceConnected(ComponentName className, IBinder binder) {
            mServiceBinder = ((BackgroundMusicService.MyBinder) binder).getService();
            Log.d("ServiceConnection","connected");
            updateButtonEnabled();
        }

        public void onServiceDisconnected(ComponentName className) {
            Log.d("ServiceConnection", "disconnected");
            mServiceBinder = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_service);

        mBtnPlay = findViewById(R.id.btn_play);
        mBtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mServiceBinder != null) {
                    mServiceBinder.play();
                }
                updateButtonEnabled();
            }
        });
        mBtnStop = findViewById(R.id.btn_stop);
        mBtnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mServiceBinder != null) {
                    mServiceBinder.stop();
                }
                updateButtonEnabled();
            }
        });
    }

    private void updateButtonEnabled() {
        if (mServiceBinder != null) {
            if (mServiceBinder.isPlaying()) {
                mBtnPlay.setEnabled(false);
                mBtnStop.setEnabled(true);
            } else {
                mBtnPlay.setEnabled(true);
                mBtnStop.setEnabled(false);
            }
        } else {
            mBtnPlay.setEnabled(false);
            mBtnStop.setEnabled(false);
        }
    }

    public void doBindService() {
        Intent intent = null;
        intent = new Intent(this, BackgroundMusicService.class);
        bindService(intent, myConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onResume() {
        Log.d("activity", "onResume");
        super.onResume();
        if (mServiceBinder == null) {
            // 서비스에 바인드
            doBindService();
        }
        startService(new Intent(getApplicationContext(), BackgroundMusicService.class));
    }

    @Override
    protected void onPause() {
        Log.d("activity", "onPause");
        super.onPause();
        if (mServiceBinder != null) {
            mIsPlaying = mServiceBinder.isPlaying();
            if (!mIsPlaying) {
                mServiceBinder.stopSelf();
            } else {
                onNotification();
            }
            unbindService(myConnection);
            mServiceBinder = null;
        }
    }

    protected void onNotification(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.musicplay);
        builder.setContentTitle("My Music Play, Click Me!");
        builder.setContentText("Hi, This is My Music Play");

        Intent notificationIntent = new Intent(this, StartServiceActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(501, builder.build());
    }
}
