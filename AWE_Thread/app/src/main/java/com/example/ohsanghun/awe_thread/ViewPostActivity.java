package com.example.ohsanghun.awe_thread;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

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
    }

    @Override
    public void onClick(View view) {

        new Thread(new Runnable() {
            @Override
            public void run() {
//                final Bitmap bitmap = loadImageFromNetwork("http://");
                imageViewPost.post(new Runnable() {
                    @Override
                    public void run() {
//                        imageViewPost.setImageBitmap(bitmap);
                    }
                });

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
