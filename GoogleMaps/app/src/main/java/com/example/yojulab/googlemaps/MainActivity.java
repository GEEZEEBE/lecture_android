package com.example.yojulab.googlemaps;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        int id = view.getId();
        Intent intent = null;
        String text = ((Button) view).getText().toString();
        Bundle bundle = new Bundle();
        Class<?> cls = null;
        switch (id) {
            case R.id.mapSimpleButton:
                cls = MapSimpleActivity.class;
                break;
            case R.id.mapMyLocationButton:
                cls = MapMyLocationActivity.class;
                break;
            default:
                cls = MainActivity.class;
        }

        intent = new Intent(this, cls);

        startActivity(intent);
    }

}
