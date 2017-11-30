package com.example.ohsanghun.awe_fragments;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
            case R.id.button4:
                cls = XmlFragmentMotherActivity.class;
                break;
            case R.id.button:
                cls = CodeFragmentMotherActivity.class;
                break;
            case R.id.button2:
                cls = BundleFragmentMotherWithActivity.class;
                break;
            default:
        }

        // Storing bundle object into intent
        bundle.putString("bundleName", text);
        bundle.putLong("bundleId", id);

        intent = new Intent(this, cls);
        intent.putExtras(bundle);

        // Result from sub Activity
        startActivityForResult(intent, Activity.RESULT_FIRST_USER);
    }
}
