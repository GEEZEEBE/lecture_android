package com.example.ohsanghun.awe_widget;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TextViewActivity extends AppCompatActivity {

    Button button;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);

        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);
    }

    public void onClickWidget(View view){
        int id = view.getId();
        String text = ((Button) view).getText().toString();
        switch (id) {
            case R.id.button:
                textView.setText(text);
                break;
            default:
        }
    }

}
