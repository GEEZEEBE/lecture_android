package com.example.ohsanghun.awe_thread;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class ViewPostActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imageViewPost ;
    ProgressBar progressBarPost;

    private int mProgressBarStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_post);

        imageViewPost = (ImageView) findViewById(R.id.imageViewPost);
        progressBarPost = (ProgressBar) findViewById(R.id.progressBarPost);
        Button buttonRun = (Button) findViewById(R.id.buttonRun);
        buttonRun.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                String strUri = "https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png";
//                final Bitmap bitmap = loadImageFromNetwork();
                try {
                    URL url = new URL(strUri);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.connect();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    final Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                    imageViewPost.post(new Runnable() {
                        @Override
                        public void run() {
                            imageViewPost.setImageBitmap(bitmap);
                        }
                    });
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mProgressBarStatus < 100){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    mProgressBarStatus ++;

                    progressBarPost.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBarPost.setProgress(mProgressBarStatus);
                        }
                    });
                }
            }
        }).start();
    }
}
