package com.example.ohsanghun.awe_audio;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AudioMediaPlayerActivity extends AppCompatActivity {

    private View b1,b2,b3,b4;
    private MediaPlayer mediaPlayer;
    private double startTime = 0;
    private double finalTime = 0;
    private int forwardTime = 5000;
    private int backwardTime = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_media_player);

        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);

        mediaPlayer = MediaPlayer.create(this, R.raw.thunder_rain);
        b2.setEnabled(false);

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Playing sound",Toast.LENGTH_SHORT).show();
                mediaPlayer.start();

                finalTime = mediaPlayer.getDuration();
                startTime = mediaPlayer.getCurrentPosition();

                b2.setEnabled(true);
                b3.setEnabled(false);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Pausing sound",Toast.LENGTH_SHORT).show();
                mediaPlayer.pause();
                b2.setEnabled(false);
                b3.setEnabled(true);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = (int)startTime;

                if((temp+forwardTime)<=finalTime){
                    startTime = startTime + forwardTime;
                    mediaPlayer.seekTo((int) startTime);
                    Toast.makeText(getApplicationContext(),"You have Jumped forward 5 seconds",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Cannot jump forward 5 seconds",Toast.LENGTH_SHORT).show();
                }
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = (int)startTime;

                if((temp-backwardTime)>0){
                    startTime = startTime - backwardTime;
                    mediaPlayer.seekTo((int) startTime);
                    Toast.makeText(getApplicationContext(),"You have Jumped backward 5 seconds",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Cannot jump backward 5 seconds",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
