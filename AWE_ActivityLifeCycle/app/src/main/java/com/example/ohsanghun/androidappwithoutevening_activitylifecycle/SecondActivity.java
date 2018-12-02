package com.example.ohsanghun.androidappwithoutevening_activitylifecycle;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;

public class SecondActivity extends AppCompatActivity {

    final String TAG = "States";
    final String ACTIVITY = "SecondActivity:";

    @Override
    public void finish() {
        super.finish();
        Log.d(TAG, ACTIVITY + " finish()");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Log.d(TAG, ACTIVITY + " -------------------------------------------");
        Log.d(TAG, ACTIVITY + " onCreate()");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean result = super.onCreateOptionsMenu(menu);
        menu.add(0, 20, 1, "Red");
        menu.add(0, 22, 2, "Green");
        return  result;
    }

    public void onNextActivity(View view){
        Intent intent = null;
        intent = new Intent(getApplicationContext(), ThirdActivity.class);
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
