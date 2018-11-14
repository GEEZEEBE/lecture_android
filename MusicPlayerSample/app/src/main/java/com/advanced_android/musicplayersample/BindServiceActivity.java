package com.advanced_android.musicplayersample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class BindServiceActivity extends AppCompatActivity implements View.OnClickListener {
    private BackgroundMusicService mServiceBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_service);

        View btn_play = findViewById(R.id.btn_play);
        View btn_stop = findViewById(R.id.btn_stop);

        btn_play.setOnClickListener(this);
        btn_stop.setOnClickListener(this);

    }

//    public void doBindService() {
//        Intent intent = null;
//        intent = new Intent(this, BackgroundMusicService.class);
//        bindService(intent, myConnection, Context.BIND_AUTO_CREATE);
//    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        Intent intent = null;
        Class<?> cls = null;
        switch (id) {
            case R.id.btn_play:
                if (mServiceBinder != null) {
                    mServiceBinder.play();
                }
                break;
            case R.id.btn_stop:
                if (mServiceBinder != null) {
                    mServiceBinder.stop();
                }
                break;
        }
//        intent = new Intent(this, cls);
//        startActivity(intent);
    }
}
