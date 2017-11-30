package com.example.ohsanghun.awe_event;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AndroidonClickActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_androidon_click);
    }

    public void onClickButton(View view){
        Toast.makeText(this, String.valueOf(view.getId()), Toast.LENGTH_LONG).show();
    }
}
