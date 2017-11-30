package com.example.ohsanghun.awe_audio;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;


public class AudioMediaPlayerWithRunnableActivity extends AppCompatActivity {

    private Button pauseBtn,playBtn;
    private MediaPlayer mediaPlayer;
    private double startTime = 0;
    private Handler myHandler = new Handler();;
    private TextView tx1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_media_player_runnable);

        pauseBtn = (Button) findViewById(R.id.button2);
        playBtn=(Button)findViewById(R.id.button3);

        tx1=(TextView)findViewById(R.id.textView2);

        mediaPlayer = MediaPlayer.create(this, R.raw.thunder_rain);
        pauseBtn.setEnabled(false);

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Playing sound",Toast.LENGTH_SHORT).show();
                mediaPlayer.start();

                startTime = mediaPlayer.getCurrentPosition();

                tx1.setText(String.format("%d min, %d sec",
                        TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                        TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) startTime)))
                );

                myHandler.postDelayed(UpdateSongTime,100);
                pauseBtn.setEnabled(true);
                playBtn.setEnabled(false);
            }
        });

        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Pausing sound",Toast.LENGTH_SHORT).show();
                mediaPlayer.pause();
                pauseBtn.setEnabled(false);
                playBtn.setEnabled(true);
            }
        });

    }

    private Runnable UpdateSongTime = new Runnable() {
        public void run() {
            startTime = mediaPlayer.getCurrentPosition();
            tx1.setText(String.format("%d min, %d sec",

                    TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                    TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                    toMinutes((long) startTime)))
            );
            myHandler.postDelayed(this, 100);
        }
    };
}
