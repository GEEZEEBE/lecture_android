package com.example.ohsanghun.awe_widget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RadioButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radiogroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String text = "CheckedId : " + checkedId;
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
            }
        });
    }

    protected void onClickWidget(View view){
        int id = view.getId();
        String text = null;
        switch (id) {
            case R.id.radiogroupbutton01:
                text = ((RadioButton)view).getText().toString();
                text = text + " - " + ((RadioButton)view).isChecked();
                break;
            case R.id.radiogroupbutton02:
                text = ((RadioButton)view).getText().toString();
                text = text + " - " + ((RadioButton)view).isChecked();
                break;
            default:
                text = "Noting!";
        }

        Toast.makeText(view.getContext(), text, Toast.LENGTH_SHORT).show();
    }
}
