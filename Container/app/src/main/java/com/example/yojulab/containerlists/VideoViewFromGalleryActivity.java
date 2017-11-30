package com.example.yojulab.containerlists;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.yojulab.containerlists.R;

import java.io.IOException;

public class VideoViewFromGalleryActivity extends AppCompatActivity {
    private static final int RESULT_LOAD_VIDEO = 401;

    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view_from_gallery);

        Button videoViewFromGalleryButton = (Button) findViewById(R.id.videoViewFromGalleryButton);
        videoView = (VideoView) findViewById(R.id.videoViewFromGallery);

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        videoViewFromGalleryButton.setOnClickListener(clickListener);
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setType("video/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent,"Select Video"),RESULT_LOAD_VIDEO);
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_VIDEO) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    String videoPath = data.getData().toString();
                    Toast.makeText(this, "Video saved to:\n" + videoPath, Toast.LENGTH_LONG).show();
                    videoView.setVideoPath(videoPath);
                    videoView.start();
                }
            } else {
                Toast.makeText(this, "Failed to record video", Toast.LENGTH_LONG).show();
            }
        }
    }

}
