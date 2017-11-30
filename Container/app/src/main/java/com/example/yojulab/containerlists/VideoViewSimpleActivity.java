package com.example.yojulab.containerlists;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.yojulab.containerlists.R;

import java.io.IOException;
import java.net.URI;

public class VideoViewSimpleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view_simple);

        String path1 = "https://youtu.be/qTUGWkJEMqw";
        String path2 = "http://commonsware.com/misc/test2.3gp";
        String path3 = "http://192.168.0.168:5000/static/Armbot.mp4";

        VideoView videoView = (VideoView) findViewById(R.id.videoViewSimple);
        try {
            String link = path3;
//            MediaController mediaController = new MediaController(this);
//            mediaController.setAnchorView(videoView);
            Uri video = Uri.parse(link);
//            videoView.setMediaController(mediaController);
            videoView.setVideoURI(video);
            videoView.start();
        } catch (Exception e) {
            Toast.makeText(this, "Error connecting", Toast.LENGTH_SHORT).show();
        }
    }
}
