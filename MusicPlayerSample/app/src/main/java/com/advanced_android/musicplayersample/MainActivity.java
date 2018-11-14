package com.advanced_android.musicplayersample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View buttonBindService = findViewById(R.id.buttonBindService);
        View buttonStartService = findViewById(R.id.buttonStartService);

        buttonBindService.setOnClickListener(this);
        buttonStartService.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        Intent intent = null;
        Class<?> cls = null;
        switch (id) {
            case R.id.buttonBindService:
                cls = BindServiceActivity.class;
                break;
            case R.id.buttonStartService:
                cls = StartServiceActivity.class;
                break;
        }
        intent = new Intent(this, cls);
        startActivity(intent);

    }
}

