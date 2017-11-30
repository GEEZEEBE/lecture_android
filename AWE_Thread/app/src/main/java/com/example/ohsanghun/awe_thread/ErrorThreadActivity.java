package com.example.ohsanghun.awe_thread;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ErrorThreadActivity extends AppCompatActivity {
    private static final String TAG = "ErrorThreadActivityTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error_thread);
    }

    public void onClick(View view){
        long endTime = System.currentTimeMillis() + 20 * 5000;

        Log.i(TAG, "Thread running !");
        TextView threadValue = (TextView) findViewById(R.id.threadValue);

        while (System.currentTimeMillis() < endTime){
            synchronized (this){
                try {
                    Log.i(TAG, "Thread running !");
                    threadValue.setText(String.valueOf(System.currentTimeMillis()));
                    wait(endTime - System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        threadValue.setText("Error Pressed!");
    }

}
