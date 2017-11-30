package com.example.ohsanghun.awe_activities;

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
            case R.id.basicActivity:
                cls = BasicActivity.class;
                break;
            case R.id.fullScreenActivity:
                cls = FullscreenActivity.class;
                break;
            case R.id.loginActivity:
                cls = LoginActivity.class;
                break;
            case R.id.masterDetailActivity:
                cls = ItemListActivity.class;
                break;
            case R.id.navigationDrawerActivity:
                cls = NavigationDrawerActivity.class;
                break;
            case R.id.scrollingActivity:
                cls = ScrollingActivity.class;
                break;
            case R.id.settingsActivity:
                cls = SettingsActivity.class;
                break;
            case R.id.tabActivity:
                cls = TabActivity.class;
                break;
            default:
                cls = MainActivity.class;
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
