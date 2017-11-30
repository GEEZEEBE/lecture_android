package com.example.ohsanghun.aweoptionsmenu;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickOptionsMenu(View view) {
        int id = view.getId();
        Intent intent = null;
        String text = ((Button) view).getText().toString();
        Bundle bundle = new Bundle();
        Class<?> cls = null;
        switch (id) {
            case R.id.optionsMenuNormal:
                cls = OptionsMenuNormalActivity.class;
                break;
            case R.id.optionsMenuIntent:
                cls = OptionsMenuIntentActivity.class;
                break;
            case R.id.optionsMenuNobar:
                cls = OptionsMenuNoBarActivity.class;
                break;
            case R.id.optionsMenuXML:
                cls = OptionsMenuXMLActivity.class;
                break;
        }
        intent = new Intent(this, cls);

        intent.putExtra("subActivity","Send Value Directly!");
        startActivity(intent);
    }

}
