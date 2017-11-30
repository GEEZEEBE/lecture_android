package com.example.yojulab.containerlists;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.yojulab.containerlists.R;

import java.io.File;

public class VideoViewTakeCameraActivity extends AppCompatActivity {

    private static final int VIDEO_CAPTURE = 201;

    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view_take_camera);

        Button videoviewButton = (Button) findViewById(R.id.takeCamera);
        videoView = (VideoView) findViewById(R.id.videoViewTakeCamera);

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        videoviewButton.setOnClickListener(clickListener);
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(!getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY)){
                Toast.makeText(getApplicationContext(),"No Have Any Camera!", Toast.LENGTH_LONG);
            } else {
//                String mediaName = "/awe_video.mp4";
//                File mediaFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+mediaName);
//                Uri videoUri = Uri.fromFile(mediaFile);

                Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
//                intent.putExtra(MediaStore.EXTRA_OUTPUT, videoUri);
                startActivityForResult(intent, VIDEO_CAPTURE);
            }
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == VIDEO_CAPTURE) {
            if (resultCode == RESULT_OK) {
                Uri videoUri = data.getData();
                Toast.makeText(this, "Video saved to:\n" + videoUri, Toast.LENGTH_LONG).show();
                videoView.setVideoURI(videoUri);
                videoView.start();
            } else {
                Toast.makeText(this, "Failed to record video",
                        Toast.LENGTH_LONG).show();
            }
        }
    }
}
