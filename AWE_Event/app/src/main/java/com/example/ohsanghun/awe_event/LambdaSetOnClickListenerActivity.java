package com.example.ohsanghun.awe_event;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class LambdaSetOnClickListenerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lambda_set_on_click_listener);

        Button listViewButton = (Button) findViewById(R.id.listviewButton);
        Button webViewButton = (Button) findViewById(R.id.webviewButton);
        Button imageViewButton = (Button) findViewById(R.id.imageviewButton);
        Button videoviewButton = (Button) findViewById(R.id.videoviewButton);
        Button restApiButton = (Button) findViewById(R.id.restApiButton);

        listViewButton.setOnClickListener(clickListener);
        webViewButton.setOnClickListener(clickListener);
        imageViewButton.setOnClickListener(clickListener);
        videoviewButton.setOnClickListener(clickListener);
        restApiButton.setOnClickListener(clickListener);
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.listviewButton:
                    ViewGroup.LayoutParams params = ((Button)view).getLayoutParams();
                    Toast.makeText(view.getContext(), ((Button)view).getText(), Toast.LENGTH_LONG).show();
                    break;
                case R.id.webviewButton:
                    Toast.makeText(view.getContext(), ((Button)view).getText(), Toast.LENGTH_LONG).show();
                    break;
                case R.id.imageviewButton:
                    Toast.makeText(view.getContext(), ((Button)view).getText(), Toast.LENGTH_LONG).show();
                    break;
                case R.id.videoviewButton:
                    Toast.makeText(view.getContext(), ((Button)view).getText(), Toast.LENGTH_LONG).show();
                    break;
                case R.id.restApiButton:
                    Toast.makeText(view.getContext(), ((Button)view).getText(), Toast.LENGTH_LONG).show();
                    break;
            }
        }
    };

}
