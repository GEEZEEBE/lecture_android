package com.example.sanghunoh.cardrecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view){
        int id = view.getId();
        Intent intent = null;
        String text = ((Button) view).getText().toString();
        Bundle bundle = new Bundle();
        Class<?> cls = null;
        switch (id) {
            case R.id.recyclerview:
                cls = RecyclerViewActivity.class;
                bundle.putString("layoutType", "linaer");
                break;
            case R.id.gridrecyclerview:
                cls = RecyclerViewActivity.class;
                bundle.putString("layoutType", "grid");
                break;
            case R.id.staggeredgridLayout:
                cls = RecyclerViewActivity.class;
                bundle.putString("layoutType", "staggeredgrid");
                break;
            case R.id.recyclerviewfromdetailactivity:
                cls = RecyclerViewFromDetailActivity.class;
                break;
            case R.id.scrolling:
                cls = ScrollingActivity.class;
                break;
            default:
                cls = MainActivity.class;
        }

        intent = new Intent(this, cls);
        intent.putExtras(bundle);

//        startActivity(intent);
        startActivityForResult(intent, 100);
    }
}
