package com.example.yojulab.containerlists;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.yojulab.containerlists.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ImageViewFromGalleryActivity extends AppCompatActivity {

    private static final int RESULT_LOAD_IMAGE = 101;

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view_from_gallery);

        Button imageViewButton = (Button) findViewById(R.id.fromGalleryButton);
        imageView = (ImageView) findViewById(R.id.imageViewFromGallery);

        imageViewButton.setOnClickListener(clickListener);
   }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
//            intent = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
//            startActivityForResult(Intent.createChooser(intent, "Select Picture"), RESULT_LOAD_IMAGE);
            startActivityForResult(intent, RESULT_LOAD_IMAGE);
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE) {
            if (resultCode == RESULT_OK) {
                Bitmap bitmap=null;
                if (data != null) {
//                    int resizedWidth = 200;
//                    int resizedHeight = 600;
//                        bitmap.createScaledBitmap(bitmap, resizedWidth, resizedHeight, false);
//                    bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), data.getData());
                    Uri selectedImage = data.getData();

                    InputStream inputStream = null;
                    if (ContentResolver.SCHEME_CONTENT.equals(selectedImage.getScheme())) {
                        try {
                            inputStream = this.getContentResolver().openInputStream(selectedImage);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    } else {
                        if (ContentResolver.SCHEME_FILE.equals(selectedImage.getScheme())) {
                            try {
                                inputStream = new FileInputStream(selectedImage.getPath());
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    bitmap = BitmapFactory.decodeStream(inputStream);
                    imageView.setImageBitmap(bitmap);
                }

            } else {
                Toast.makeText(this, "Failed to record video",
                        Toast.LENGTH_LONG).show();
            }
        }
    }

}
