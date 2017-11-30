package com.example.ohsanghun.awe_sharedpreferences;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickReference(View view) {
        int id = view.getId();
        Intent intent = null;
        Class<?> cls = null;
        switch (id) {
            case R.id.reference_input:
                cls = ReferenceInputActivity.class;
                break;
            case R.id.reference_get:
                cls = ReferenceGetActivity.class;
                break;
        }
        intent = new Intent(this, cls);
        startActivity(intent);
    }

}
