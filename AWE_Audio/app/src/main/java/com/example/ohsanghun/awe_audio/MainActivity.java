package com.example.ohsanghun.awe_audio;

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

    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.audioSimpleButton:
                intent = new Intent(getApplicationContext(), AudioSimpleActivity.class);
                break;
            case R.id.audioMediaPlayerButton:
                intent = new Intent(getApplicationContext(), AudioMediaPlayerActivity.class);
                break;
            case R.id.audioMediaPlayerWithRunableButton:
                intent = new Intent(getApplicationContext(), AudioMediaPlayerWithRunnableActivity.class);
                break;
        }
        startActivity(intent);
    }
}
