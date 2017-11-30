package com.example.ohsanghun.awe_event;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AnonymousClassSetOnClickListenerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anonymousclass_set_on_click_listener);

        Button listViewButton = (Button) findViewById(R.id.listviewButton);
        Button webViewButton = (Button) findViewById(R.id.webviewButton);
        Button imageViewButton = (Button) findViewById(R.id.imageviewButton);
        Button videoviewButton = (Button) findViewById(R.id.videoviewButton);
        Button restApiButton = (Button) findViewById(R.id.restApiButton);

        listViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), ((Button)view).getText(), Toast.LENGTH_LONG).show();
            }
        });
        webViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), ((Button)view).getText(), Toast.LENGTH_LONG).show();
            }
        });
        imageViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), ((Button)view).getText(), Toast.LENGTH_LONG).show();
            }
        });
        videoviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), ((Button)view).getText(), Toast.LENGTH_LONG).show();
            }
        });
        restApiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), ((Button)view).getText(), Toast.LENGTH_LONG).show();
            }
        });

    }
}
