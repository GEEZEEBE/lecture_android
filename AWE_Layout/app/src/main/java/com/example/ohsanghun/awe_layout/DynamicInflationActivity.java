package com.example.ohsanghun.awe_layout;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class DynamicInflationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Make Inflater View
        View inflaterView = (View) getLayoutInflater().inflate(R.layout.activity_dynamicinflation_layout, null);
        LinearLayout linearLayout = (LinearLayout) inflaterView.findViewById(R.id.subLinearID);
        Button button = new Button(this);
        button.setId(R.id.dynamicButtonId);
        button.setText("Press Me");
        button.setBackgroundColor(Color.BLUE);
        button.setWidth(50);

        linearLayout.addView(button);
        setContentView(linearLayout);
    }
}
