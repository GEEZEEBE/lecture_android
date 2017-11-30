package com.example.ohsanghun.androidappwithoutevening;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ExplicitIntentResponseActivity extends AppCompatActivity {

    @Override
    public void finish() {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();

        EditText editText = (EditText) findViewById(R.id.resultValue);
        bundle.putString("resultValue", editText.getText().toString());
        intent.putExtras(bundle);

        setResult(Activity.RESULT_FIRST_USER, intent);
        super.finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_intent_response);

        // getting data from bundle
        Bundle bundle = getIntent().getExtras();

        TextView textView = (TextView) findViewById(R.id.singleName);
        textView.setText(bundle.getString("singleName","No Data"));

        TextView bundleName = (TextView) findViewById(R.id.bundleName);
        bundleName.setText(String.valueOf(bundle.getLong("bundleName")));

//        TextView bundlePosition = (TextView) findViewById(R.id.bundlePosition);
//        Long longBundlePosition = bundle.getLong("bundlePosition");
//        bundlePosition.setText(Long.toString(longBundlePosition));

        Button button = (Button) findViewById(R.id.explicitIntentResponse01);
        button.setOnClickListener(clickListener);

    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };

}
