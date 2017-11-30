package com.example.ohsanghun.androidappwithoutevening;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ExplicitIntentRequestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_intent_request);

        // getting data from bundle
        Bundle bundle = getIntent().getExtras();

        TextView textView = (TextView) findViewById(R.id.singleName);
        textView.setText(bundle.getString("singleName","No Data"));

        TextView bundleName = (TextView) findViewById(R.id.bundleName);
        bundleName.setText(String.valueOf(bundle.getLong("bundleName")));

    }
}
