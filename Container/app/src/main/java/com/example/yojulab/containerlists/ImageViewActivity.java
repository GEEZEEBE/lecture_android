package com.example.yojulab.containerlists;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.yojulab.containerlists.R;

import java.io.File;
import java.io.IOException;

public class ImageViewActivity extends AppCompatActivity {

    private static final int IMAGE_CAPTURE = 102;
    ImageView imageView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

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
            startActivityForResult(intent, IMAGE_CAPTURE);
        }
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == IMAGE_CAPTURE) {
            if (resultCode == RESULT_OK) {
                Bundle bundle = data.getExtras();
                Bitmap bitmap = (Bitmap) bundle.get("data");
                imageView.setImageBitmap(bitmap);
            } else {
                Toast.makeText(this, "Failed to record video",
                        Toast.LENGTH_LONG).show();
            }
        }
    }
}
