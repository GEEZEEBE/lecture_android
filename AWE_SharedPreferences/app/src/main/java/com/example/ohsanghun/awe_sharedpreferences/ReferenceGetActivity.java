package com.example.ohsanghun.awe_sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ReferenceGetActivity extends AppCompatActivity {

    public static final String AWEPREFERENCES = "AWEPrefs" ;
    public static final String Name = "nameKey";
    public static final String Phone = "phoneKey";
    public static final String Email = "emailKey";
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reference_get);

        sharedPreferences = getSharedPreferences(AWEPREFERENCES, Context.MODE_PRIVATE);
        String nameKey = sharedPreferences.getString("nameKey", null);
        String phoneKey = sharedPreferences.getString("phoneKey", null);
        String emailKey = sharedPreferences.getString("emailKey", null);

        TextView textView = (TextView) findViewById(R.id.referencesValues);
        textView.setText(nameKey + ", " + phoneKey + ", " + emailKey);
    }
}
