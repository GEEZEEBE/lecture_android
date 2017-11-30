package com.example.ohsanghun.awe_widget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ProgressBarActivity extends AppCompatActivity {

    ToggleButton toggleButton;
    ProgressBar progressBar01;
    ProgressBar progressBar02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);

        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        progressBar01 = (ProgressBar) findViewById(R.id.progressBar);
        progressBar02 = (ProgressBar) findViewById(R.id.progressBar2);

    }

    public void onClickWidget(View view) {
        int id = view.getId();
        String text = null;
        switch (id) {
            case R.id.toggleButton:
//                text = ((CheckBox)view).getText().toString();
                text = toggleButton.getText().toString();
                text = text + " - " + toggleButton.isChecked();
                if(toggleButton.isChecked()){
                    progressBar01.setVisibility(View.VISIBLE);
                    progressBar02.setVisibility(View.GONE);
                } else {
                    progressBar01.setVisibility(View.GONE);
                    progressBar02.setVisibility(View.VISIBLE);
                }
            default:
                text = "Noting!";
        }

        Toast.makeText(view.getContext(), text, Toast.LENGTH_SHORT).show();
    }

}
