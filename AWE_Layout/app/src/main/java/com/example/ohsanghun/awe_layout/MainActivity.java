package com.example.ohsanghun.awe_layout;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickLinearLayout(View view) {
        Toast.makeText(this, "Click buttonLinearlayout!", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(getApplicationContext(), LinearLayoutActivity.class);
        startActivity(intent);
    }

    public void onClickLayout(View view) {
        int id = view.getId();
        CharSequence text = null;
        Intent intent = null;
        Class<?> cls = null;
        switch (id) {
            case R.id.buttonRelativelayout:
                text = "Click buttonRealtivelayout!";
                cls = RelativeLayoutActivity.class;
                break;
            case R.id.buttonTablelayout:
                text = "Click buttonTablelayout!";
                cls = TableLayoutActivity.class;
                break;
            case R.id.buttonGridlayout:
                text = "Click buttonGridlayout!";
                cls = GridLayoutActivity.class;
                break;
            case R.id.buttonNavigationDrwawerlayout:
                text = "Click buttonNavigationDrwawerlayout!";
                cls = NavigationDrawerActivity.class;
                break;
            case R.id.buttonFramelayout:
                text = "Click buttonFramelayout!";
                cls = FrameLayoutActivity.class;
                break;
            case R.id.buttonDynamicInflation:
                text = "Click buttonDynamicInflation!";
                cls = DynamicInflationActivity.class;
                break;
            // even more buttons here
        }
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        intent = new Intent(this, cls);
        startActivity(intent);
    }
}
