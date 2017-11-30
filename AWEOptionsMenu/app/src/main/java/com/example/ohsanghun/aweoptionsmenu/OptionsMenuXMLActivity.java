package com.example.ohsanghun.aweoptionsmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class OptionsMenuXMLActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_menu_xml);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.xml_activity, menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String menuString = (String) item.getTitle();
        boolean returnResult ;
        switch(item.getItemId()){
            case R.id.menu_red :
                returnResult = true;
                break;
            case R.id.menu_green :
                returnResult = true;
                break;
            default:
                returnResult = super.onOptionsItemSelected(item);
        }
        Toast.makeText(getApplicationContext(), menuString, Toast.LENGTH_SHORT).show();
        return returnResult;
    }

}
