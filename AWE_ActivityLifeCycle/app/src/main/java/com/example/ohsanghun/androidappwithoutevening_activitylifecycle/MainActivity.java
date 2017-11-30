package com.example.ohsanghun.androidappwithoutevening_activitylifecycle;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    final String TAG = "States";
    final String ACTIVITY = "MainActivity:";

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, ACTIVITY + " onRestoreInstanceState()");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.d(TAG, ACTIVITY + " onSaveInstanceState()");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, ACTIVITY + " -------------------------------------------");
        Log.d(TAG, ACTIVITY + " onCreate()");
    }

    public void onNextActivity(View view){
        Intent intent = null;
        intent = new Intent(getApplicationContext(), SecondActivity.class);
//        startActivityForResult(intent, RESULT_OK);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, ACTIVITY + " onActivityResult()");
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
