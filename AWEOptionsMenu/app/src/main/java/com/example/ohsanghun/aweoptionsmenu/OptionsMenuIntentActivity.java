package com.example.ohsanghun.aweoptionsmenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class OptionsMenuIntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_menu_intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean result = super.onCreateOptionsMenu(menu);
        menu.add(0, R.id.menu_red, 1, R.string.red_string);
        menu.add(0, R.id.menu_green, 2, R.string.green_string);
        return  result;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String menuString = (String) item.getTitle();
        boolean returnResult ;

        Intent intent ;
        Class<?> cls = null ;
        switch(item.getItemId()){
            case R.id.menu_red :
                returnResult = true;
                cls = OptionsMenuNoBarActivity.class;
                break;
            case R.id.menu_green :
                returnResult = true;
                cls = OptionsMenuNoBarActivity.class;
                break;
            default:
                returnResult = super.onOptionsItemSelected(item);
                cls = OptionsMenuIntentActivity.class;
        }

        intent = new Intent(getApplicationContext(), cls);
        startActivity(intent);
        return returnResult;
    }
}
