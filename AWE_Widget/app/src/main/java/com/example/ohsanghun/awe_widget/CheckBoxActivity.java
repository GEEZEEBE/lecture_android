package com.example.ohsanghun.awe_widget;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.Toast;

public class CheckBoxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

    }

    public void onClickWidget(View view) {
        int id = view.getId();
        String text = null;
        switch (id) {
            case R.id.checkbox01:
                text = ((CheckBox)view).getText().toString();
                text = text + " - " + ((CheckBox)view).isChecked();
                break;
            case R.id.checkbox02:
                text = ((CheckBox)view).getText().toString();
                text = text + " - " + ((CheckBox)view).isChecked();
                break;
            default:
                text = "Noting!";
        }

        Toast.makeText(view.getContext(), text, Toast.LENGTH_SHORT).show();
    }
}
