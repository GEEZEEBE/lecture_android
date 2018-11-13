package com.example.yojulab.containerlists;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ImageViewActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.imageViewFromGalleryButton:
                intent = new Intent(view.getContext(), ImageViewFromGalleryActivity.class);
                break;
            case R.id.imageviewButton:
                intent = new Intent(view.getContext(), ImageViewTakeCameraActivity.class);
                break;
            case R.id.buttonImageViewTakeCameraWithFile:
                intent = new Intent(view.getContext(), ImageViewTakeCameraWithFileActivity.class);
                break;
        }
        startActivity(intent);
//            startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == RESULT_OK) {
            if (data.hasExtra("?")) {
                Toast.makeText(getApplicationContext(),
                        data.getStringExtra("?"), Toast.LENGTH_LONG).show();
            }
        }
    }
}
