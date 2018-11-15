package com.advanced_android.musicplayersample;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class BindServiceActivity extends AppCompatActivity implements View.OnClickListener {
    private BackgroundMusicWithBindServiceService myServiceBinder;
    // 서비스와의 연결 콜백
    private ServiceConnection myConnection = new ServiceConnection() {

        public void onServiceConnected(ComponentName className, IBinder binder) {
            myServiceBinder = ((BackgroundMusicWithBindServiceService.MyBinder) binder).getService();
            Log.d("ServiceConnection","connected");
//            updateButtonEnabled();
        }

        public void onServiceDisconnected(ComponentName className) {
            Log.d("ServiceConnection", "disconnected");
            myServiceBinder = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_service);

        View btn_play = findViewById(R.id.btn_play);
        View btn_stop = findViewById(R.id.btn_stop);

        btn_play.setOnClickListener(this);
        btn_stop.setOnClickListener(this);

        Intent intent = new Intent(this, BackgroundMusicWithBindServiceService.class);
        bindService(intent, myConnection, Context.BIND_AUTO_CREATE);
    }

//    public void doBindService() {
//        Intent intent = null;
//        intent = new Intent(this, BackgroundMusicWithBindServiceService.class);
//        bindService(intent, myConnection, Context.BIND_AUTO_CREATE);
//    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        Intent intent = null;
        Class<?> cls = null;
        switch (id) {
            case R.id.btn_play:
                if (myServiceBinder != null) {
                    myServiceBinder.play();
                }
                break;
            case R.id.btn_stop:
                if (myServiceBinder != null) {
                    myServiceBinder.stop();
                }
                break;
        }
//        intent = new Intent(this, cls);
//        startActivity(intent);
    }
}
