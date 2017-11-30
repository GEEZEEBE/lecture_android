package com.example.yojulab.containerlists;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yojulab.containerlists.listviewmulticolumn.ListViewAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import static com.example.yojulab.containerlists.listviewmulticolumn.Constants.*;

public class ListViewMultiColumnActivity extends AppCompatActivity {
    private ArrayList<HashMap<String, String>> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        ListView listView=(ListView)findViewById(R.id.resultList);

        list=new ArrayList<HashMap<String,String>>();

        HashMap<String,String> temp=new HashMap<String, String>();
        temp.put(FIRST_COLUMN, "Ankit Karia");
        temp.put(SECOND_COLUMN, "Male");
        temp.put(THIRD_COLUMN, "22");
        temp.put(FOURTH_COLUMN, "Unmarried");
        list.add(temp);

        HashMap<String,String> temp2=new HashMap<String, String>();
        temp2.put(FIRST_COLUMN, "Rajat Ghai");
        temp2.put(SECOND_COLUMN, "Male");
        temp2.put(THIRD_COLUMN, "25");
        temp2.put(FOURTH_COLUMN, "Married");
        list.add(temp2);

        HashMap<String,String> temp3=new HashMap<String, String>();
        temp3.put(FIRST_COLUMN, "Karina Kaif");
        temp3.put(SECOND_COLUMN, "Female");
        temp3.put(THIRD_COLUMN, "31");
        temp3.put(FOURTH_COLUMN, "Unmarried");
        list.add(temp3);

//        ListViewAdapter adapter=new ListViewAdapter(this, list, R.layout.listview_multi_column);
        ListViewAdapter adapter=new ListViewAdapter(this, list, R.layout.listview_multi_column);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id)
            {
                HashMap<String, String> item = (HashMap<String, String>)parent.getItemAtPosition(position);
                TextView textView = (TextView)view.findViewById(R.id.name);
                String name = textView.getText().toString();
                Toast.makeText(getApplicationContext(), Integer.toString(position)+" Clicked", Toast.LENGTH_SHORT).show();
            }

        });

    }
}
