package com.example.ohsanghun.awe_thread;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HandlerThreadActivity extends AppCompatActivity {
    private static final String TAG = "HandlerThreadActivityTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_thread);
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Button button = (Button)findViewById(R.id.handlerThread);
            button.setEnabled(true);
            TextView threadValue = (TextView) findViewById(R.id.threadValue);
            threadValue.setText("Handler Pressed!");
        }
    };

    @SuppressLint("LongLogTag")
    public void onClick(View view){
        Log.i(TAG, "Thread running !");

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
            long endTime = System.currentTimeMillis() + 10 * 1000;

            while (System.currentTimeMillis() < endTime){
                Log.i(TAG, "Thread running !");
//                synchronized (this){
//                    try {
//                        wait(endTime - System.currentTimeMillis());
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
                handler.sendEmptyMessage(0);
            }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}
