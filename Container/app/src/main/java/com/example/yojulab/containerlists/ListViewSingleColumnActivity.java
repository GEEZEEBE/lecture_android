package com.example.yojulab.containerlists;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yojulab.containerlists.R;

public class ListViewSingleColumnActivity extends AppCompatActivity {

    static final String[] FRUITS = new String[] { "Apple", "Avocado", "Banana",
            "Blueberry", "Coconut", "Durian", "Guava", "Kiwifruit",
            "Jackfruit", "Mango", "Olive", "Pear", "Sugar-apple" };

    @Override
    public void finish() {
        Intent intent = new Intent();

        setResult(Activity.RESULT_OK, intent);
        super.finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        // getting data from bundle
        Bundle bundle = getIntent().getExtras();

        ListView listView = (ListView) findViewById(R.id.resultList);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.listview_single_column,FRUITS);

        listView.setAdapter(arrayAdapter);

//        listView.setTextFilterEnabled(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text
                Toast.makeText(getApplicationContext(),
                        ((TextView) view).getText(), Toast.LENGTH_SHORT).show();


            }
        });
    }
}
