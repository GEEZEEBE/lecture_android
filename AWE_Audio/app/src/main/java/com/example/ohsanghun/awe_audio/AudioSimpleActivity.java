package com.example.ohsanghun.awe_audio;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class AudioSimpleActivity extends AppCompatActivity {
    View play,stop,record;
    private MediaRecorder myAudioRecorder;
    private String outputFile = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_simple);

        play=(Button)findViewById(R.id.button3);
        stop=(Button)findViewById(R.id.button2);
        record=(Button)findViewById(R.id.button);

        stop.setEnabled(false);
        play.setEnabled(false);

        myAudioRecorder=new MediaRecorder();
        myAudioRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        outputFile = Environment.getExternalStorageDirectory().getAbsolutePath() + "/recording.mp4";;
        myAudioRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
        myAudioRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
//        outputFile = Environment.getExternalStorageDirectory().getAbsolutePath() + "/recording.3gp";;
//        myAudioRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        myAudioRecorder.setOutputFile(outputFile);

        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    myAudioRecorder.prepare();
                    myAudioRecorder.start();
                }

                catch (IllegalStateException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                record.setEnabled(false);
                stop.setEnabled(true);

                Toast.makeText(getApplicationContext(), "Recording started", Toast.LENGTH_LONG).show();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAudioRecorder.stop();
                myAudioRecorder.release();
                myAudioRecorder  = null;

                stop.setEnabled(false);
                play.setEnabled(true);

                Toast.makeText(getApplicationContext(), "Audio recorded successfully",Toast.LENGTH_LONG).show();
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) throws IllegalArgumentException,SecurityException,IllegalStateException {
                MediaPlayer m = new MediaPlayer();

                try {
                    m.setDataSource(outputFile);
                }

                catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    m.prepare();
                }

                catch (IOException e) {
                    e.printStackTrace();
                }

                m.start();
                Toast.makeText(getApplicationContext(), "Playing audio", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void checkPermission(){

        int permissionCheck_RECORD = ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO);
        int permissionCheck_WRITE = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.RECORD_AUDIO)!= PackageManager.PERMISSION_GRANTED){
//(ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED)

            if ( (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.RECORD_AUDIO)) ||
                    (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE))){

// 다이어로그같은것을 띄워서 사용자에게 해당 권한이 필요한 이유에 대해 설명합니다
                // 해당 설명이 끝난뒤 requestPermissions()함수를 호출하여 권한허가를 요청해야 합니다

            } else {

                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION}, MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_RECORD_AUDIO);

// 필요한 권한과 요청 코드를 넣어서 권한허가요청에 대한 결과를 받아야 합니다

            }
        }
    }
}
