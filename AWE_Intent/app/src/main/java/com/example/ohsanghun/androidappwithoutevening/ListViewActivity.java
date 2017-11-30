package com.example.ohsanghun.androidappwithoutevening;

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

public class ListViewActivity extends AppCompatActivity {

    static final String[] FRUITS = new String[] { "Apple", "Avocado", "Banana",
            "Blueberry", "Coconut", "Durian", "Guava", "Kiwifruit",
            "Jackfruit", "Mango", "Olive", "Pear", "Sugar-apple" };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == RESULT_FIRST_USER){
            if(data.hasExtra("resultValue")){
                Toast.makeText(getApplicationContext(),
                        data.getStringExtra("resultValue"), Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        ListView listView = (ListView) findViewById(R.id.resultList);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_row,FRUITS);
        listView.setAdapter(arrayAdapter);

        listView.setTextFilterEnabled(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text
                Toast.makeText(getApplicationContext(),
                        ((TextView) view).getText(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(view.getContext(), ExplicitIntentResponseActivity.class);

                // Storing single object into intent
                intent.putExtra("singleName", ((TextView) view).getText());

                // Storing bundle object into intent
                Bundle bundle = new Bundle();
                bundle.putString("bundleName", ((TextView) view).getText().toString());
                bundle.putLong("bundlePosition", id);

                intent.putExtras(bundle);

//                startActivity(intent);

                // Result from sub Activity
                startActivityForResult(intent, Activity.RESULT_FIRST_USER);
            }
        });
    }
}
