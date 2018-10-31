package com.example.ohsanghun.androidappwithoutevening;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonSimpleDatabase = findViewById(R.id.buttonSimpleDatabase);
        Button buttonSimpleCursorAdapterWithDB = findViewById(R.id.buttonSimpleCursorAdapterWithDB);

        buttonSimpleDatabase.setOnClickListener(this);
        buttonSimpleCursorAdapterWithDB.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.buttonSimpleDatabase:
                intent = new Intent(getApplicationContext(), SimpleDataBaseActivity.class);
                break;
            case R.id.buttonSimpleCursorAdapterWithDB:
                intent = new Intent(getApplicationContext(), SimpleCursorAdapterWithDBActivity.class);
                break;
        }
        startActivity(intent);
//        startActivityForResult(intent, 1);

    }
}
