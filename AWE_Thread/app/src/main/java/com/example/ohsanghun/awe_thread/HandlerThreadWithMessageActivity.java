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

import java.text.SimpleDateFormat;
import java.util.Date;

public class HandlerThreadWithMessageActivity extends AppCompatActivity {
    private static final String TAG = "HandlerThreadWithMessageActivityTag";
    private static final String DATE_FORMAT = "HH:mm:ss MM/dd/yyyy";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_thread_with_message);
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle bundle = msg.getData();
            String currentTime = bundle.getString("currentTime");
            TextView threadValue = (TextView) findViewById(R.id.threadValue);
            threadValue.setText("Current Time : " + currentTime);
            Button button = (Button)findViewById(R.id.handlerThreadWithMessage);
            button.setEnabled(true);
        }
    };

    @SuppressLint("LongLogTag")
    public void onClick(View view){
        Log.i(TAG, "Thread running !");

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Message msg = handler.obtainMessage();
                Bundle bundle = new Bundle();

                SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
                int count = 10, repeat = 0;
                String currentTime;

//                currentTime = dateFormat.format(new Date());
//                bundle.putString("currentTime", currentTime);
//                msg.setData(bundle);
//                handler.sendMessage(msg);

/**/
                while (true){
                    Log.i(TAG, "Thread running !");
//                    synchronized (this) {
                        currentTime = dateFormat.format(new Date());
                        bundle.putString("currentTime", currentTime);
                        msg.setData(bundle);
                        handler.sendMessage(msg);
//                        try {
//                            wait(1000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
                }
/**/
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}
