package com.example.ohsanghun.androidappwithoutevening_activitylifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ThirdActivity extends AppCompatActivity {

    final String TAG = "States";
    final String ACTIVITY = "ThirdActivity:";

    @Override
    public void finish() {
        super.finish();
        Log.d(TAG, ACTIVITY + " finish()");
    }

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Log.d(TAG, ACTIVITY + " -------------------------------------------");
        Log.d(TAG, ACTIVITY + " onCreate()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, ACTIVITY + " onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, ACTIVITY + " onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, ACTIVITY + " onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, ACTIVITY + " onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, ACTIVITY + " onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, ACTIVITY + " onDestroy()");
        Log.d(TAG, ACTIVITY + " -------------------------------------------");
    }
}
