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

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Boolean mIsPlaying;
    private BackgroundMusicWithBindServiceService myServiceBinder;

    // 서비스와의 연결 콜백
    private ServiceConnection myConnection = new ServiceConnection() {

        public void onServiceConnected(ComponentName className, IBinder binder) {
            myServiceBinder = ((BackgroundMusicWithBindServiceService.MyBinder) binder).getService();
            Log.e("ServiceConnection","connected");
//            updateButtonEnabled();
        }

        public void onServiceDisconnected(ComponentName className) {
            Log.e("ServiceConnection", "disconnected");
            myServiceBinder = null;
        }
    };

    private void doBindService() {
        Intent intent = new Intent(this, BackgroundMusicWithBindServiceService.class);
        bindService(intent, myConnection, Context.BIND_AUTO_CREATE);
    }

    private void doUnBindService() {
        if (myServiceBinder != null) {
            mIsPlaying = myServiceBinder.isPlaying();
            unbindService(myConnection);
//            myServiceBinder = null;
        }
    }

    @Override
    protected void onResume() {
        Log.d("activity", "onResume");
        super.onResume();
        if (myServiceBinder == null) {
            // 서비스에 바인드
            doBindService();
        }
    }

    @Override
    protected void onPause() {
        Log.d("activity", "onPause");
        super.onPause();
        doUnBindService();
        myServiceBinder.stopSelf();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View buttonBindService = findViewById(R.id.buttonBindService);
        View buttonStartService = findViewById(R.id.buttonStartService);

        buttonBindService.setOnClickListener(this);
        buttonStartService.setOnClickListener(this);

        View btn_play = findViewById(R.id.btn_play);
        View btn_stop = findViewById(R.id.btn_stop);

        btn_play.setOnClickListener(this);
        btn_stop.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        Intent intent = null;
        Class<?> cls = null;
        switch (id) {
            case R.id.buttonBindService:
                cls = BindServiceActivity.class;
                break;
            case R.id.buttonStartService:
                cls = StartServiceActivity.class;
                break;
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

        if(cls != null){
//            doUnBindService();
            intent = new Intent(this, cls);
            startActivity(intent);
        }

    }
}

