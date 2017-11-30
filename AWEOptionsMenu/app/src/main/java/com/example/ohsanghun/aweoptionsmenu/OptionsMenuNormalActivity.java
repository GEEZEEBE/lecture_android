package com.example.ohsanghun.aweoptionsmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class OptionsMenuNormalActivity extends AppCompatActivity {

    final int MENU_GREEN = 20;
    final int MENU_RED = 22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_menu_normal);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean result = super.onCreateOptionsMenu(menu);
        menu.add(0, MENU_RED, 1, R.string.red_string);
        menu.add(0, MENU_GREEN, 2, R.string.green_string);
        return  result;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String menuString = (String) item.getTitle();
        boolean returnResult ;
        switch(item.getItemId()){
            case MENU_RED :
                returnResult = true;
                break;
            case MENU_GREEN :
                returnResult = true;
                break;
            default:
                returnResult = super.onOptionsItemSelected(item);
        }
        Toast.makeText(getApplicationContext(), menuString, Toast.LENGTH_SHORT).show();
        return returnResult;
    }
}
