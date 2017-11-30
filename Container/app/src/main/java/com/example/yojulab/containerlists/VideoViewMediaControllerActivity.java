package com.example.yojulab.containerlists;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.yojulab.containerlists.R;

public class VideoViewMediaControllerActivity extends AppCompatActivity {

    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view_mediacontroller);

        videoView = (VideoView) findViewById(R.id.videoView);
        String videoPath = "http://192.168.0.168:5000/static/Armbot.mp4";
        Uri videoUri = Uri.parse(videoPath);
        videoView.setVideoURI(videoUri);

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();
    }

}
