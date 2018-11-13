package com.example.yojulab.containerlists;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class ImageViewTakeCameraWithFileActivity extends AppCompatActivity {

    private static final int IMAGE_CAPTURE = 102;
    private String FILENAME = "/sdcard/imageViewTakeCameraWithFile.jpg";
    ImageView imageView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view_take_camera);

        Button imageCaptureButton = (Button) findViewById(R.id.imageCaptureButton);
        imageView = (ImageView) findViewById(R.id.imageView);

        imageView.setImageResource(R.drawable.scene);

        imageCaptureButton.setOnClickListener(clickListener);
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        if(!getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY)){
            Toast.makeText(getApplicationContext(),"No Have Any Camera!", Toast.LENGTH_LONG);
        } else {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            File file = new File(FILENAME);
            intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
            startActivityForResult(intent, IMAGE_CAPTURE);
        }
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == IMAGE_CAPTURE) {
            if (resultCode == RESULT_OK) {
                File file = new File(FILENAME);
                Bitmap bitmap = null;
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), Uri.fromFile(file));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                imageView.setImageBitmap(bitmap);
            } else {
                Toast.makeText(this, "Failed to record video",
                        Toast.LENGTH_LONG).show();
            }
        }
    }
}
