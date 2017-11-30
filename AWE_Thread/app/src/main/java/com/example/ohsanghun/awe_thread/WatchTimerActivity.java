package com.example.ohsanghun.awe_thread;

import android.graphics.Color;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WatchTimerActivity extends AppCompatActivity {
    Button butnstart, butnreset;
    TextView time;
    long starttime = 0L;
    long timeInMilliseconds = 0L;
    long timeSwapBuff = 0L;
    long updatedtime = 0L;
    int t = 1;
    int secs = 0;
    int mins = 0;
    int milliseconds = 0;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_timer);
        butnstart = (Button) findViewById(R.id.start);
        butnreset = (Button) findViewById(R.id.reset);
        time = (TextView) findViewById(R.id.timer);

        butnstart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (t == 1) {
                    butnstart.setText("Pause");
                    starttime = SystemClock.uptimeMillis();
                    handler.postDelayed(updateTimer, 0);
                    t = 0;
                } else {
                    butnstart.setText("Start");
                    time.setTextColor(Color.BLUE);
                    timeSwapBuff += timeInMilliseconds;
                    handler.removeCallbacks(updateTimer);
                    t = 1;
                }}
        });

        butnreset.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                starttime = 0L;
                timeInMilliseconds = 0L;
                timeSwapBuff = 0L;
                updatedtime = 0L;
                t = 1;
                secs = 0;
                mins = 0;
                milliseconds = 0;
                butnstart.setText("Start");
                handler.removeCallbacks(updateTimer);
                time.setText("00:00:00");
            }});
    }

    public Runnable updateTimer = new Runnable() {
        public void run() {
//            while(true){
                timeInMilliseconds = SystemClock.uptimeMillis() - starttime;
                updatedtime = timeSwapBuff + timeInMilliseconds;
                secs = (int) (updatedtime / 1000);
                mins = secs / 60;
                secs = secs % 60;
                milliseconds = (int) (updatedtime % 1000);
                time.setText("" + mins + ":" + String.format("%02d", secs) + ":"
                        + String.format("%03d", milliseconds));
                time.setTextColor(Color.RED);
//            handler.postDelayed(this, 0);
//            }
        }};
}
