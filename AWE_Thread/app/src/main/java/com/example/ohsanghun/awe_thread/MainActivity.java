package com.example.ohsanghun.awe_thread;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){
        int id = view.getId();
        Intent intent = null;
        Class<?> cls = null;
        switch (id){
            case R.id.errorThreadActivity:
                cls = ErrorThreadActivity.class;
                break;
            case R.id.handlerThreadActivity:
                cls = HandlerThreadActivity.class;
                break;
            case R.id.handlerThreadWithMessageActivity:
                cls = HandlerThreadWithMessageActivity.class;
                break;
            case R.id.watchTimerActivity:
                cls = WatchTimerActivity.class;
                break;
            case R.id.stopWatchActivity:
                cls = StopwatchActivity.class;
                break;
            default:
        }
        intent = new Intent(this, cls);
        startActivity(intent);
    }
}
