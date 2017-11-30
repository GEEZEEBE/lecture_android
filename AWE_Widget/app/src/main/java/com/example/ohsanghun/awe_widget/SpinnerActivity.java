package com.example.ohsanghun.awe_widget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class SpinnerActivity extends AppCompatActivity {

//    private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        Button button = (Button) findViewById(R.id.GetSpinner);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView = (TextView)findViewById(R.id.SpinnerTextView);
                textView.setText(spinner.getSelectedItem().toString());
            }
        });
        List<String> list = new ArrayList<String>();
        list.add("Apple");
        list.add("Mango");
        list.add("Banana");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this.getApplicationContext(),
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String seleted = ((TextView)view).getText().toString();
                String text = parent.getItemAtPosition(position).toString() + ", " + id + ", "+ position ;
                Toast.makeText(view.getContext(), id+ ", "+ position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplication(), "Nothing", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
