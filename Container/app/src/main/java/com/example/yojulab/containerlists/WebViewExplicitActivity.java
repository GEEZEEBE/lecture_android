package com.example.yojulab.containerlists;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import com.example.yojulab.containerlists.R;

public class WebViewExplicitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_explicit);

        Button searchButton = (Button) findViewById(R.id.searchButton);

        searchButton.setOnClickListener(clickListener);
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            EditText siteUrl = (EditText) findViewById(R.id.siteUrl);

            WebView webView = (WebView) findViewById(R.id.webView);

            webView.getSettings().setJavaScriptEnabled(true);
            webView.setWebViewClient(new WebViewClient(){
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    return super.shouldOverrideUrlLoading(view, url);
                }
            });
            webView.loadUrl(siteUrl.getText().toString());
            webView.requestFocus();
        }
    };
}
