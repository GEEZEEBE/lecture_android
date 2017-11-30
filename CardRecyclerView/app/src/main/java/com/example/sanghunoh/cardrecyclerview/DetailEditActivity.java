package com.example.sanghunoh.cardrecyclerview;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DetailEditActivity extends AppCompatActivity {


    ImageView imageView;
    EditText titles, contents;
    Uri mCurrentPhotoPath;
    String thumbnailPath;

    @Override
    public void finish() {


        int THUMBSIZE = 64;

        Bitmap ThumbImage = ThumbnailUtils.extractThumbnail(BitmapFactory.decodeFile(mCurrentPhotoPath.toString()),THUMBSIZE, THUMBSIZE);

        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("title", titles.getText().toString());
        bundle.putString("detail", contents.getText().toString());
        bundle.putString("image", thumbnailPath);
        intent.putExtras(bundle);
        setResult(RESULT_OK, intent);
        super.finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_edit);

        titles = (EditText) findViewById(R.id.titles);
        contents = (EditText) findViewById(R.id.contents);
        imageView = (ImageView) findViewById(R.id.detailImageView);
    }

    public void onClickImageView(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            mCurrentPhotoPath = getSaveExternalDirectory();
            intent.putExtra(MediaStore.EXTRA_OUTPUT, mCurrentPhotoPath);
            startActivityForResult(intent, 101);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            imageView.setImageURI(mCurrentPhotoPath);
        }
    }

    private Uri getSaveInternalDirectory(){
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + ".jpg";
        File storageDir = getFilesDir();

        Uri uri = Uri.fromFile(new File(storageDir, imageFileName));
        return uri;
    }

    private Uri getSaveExternalDirectory() {
        Uri uri;
        String url = "yojulab/" + "tmp_" + String.valueOf(System.currentTimeMillis()) + ".jpg";
        File tempFile = new File(Environment.getExternalStorageDirectory(), url);
        uri = Uri.fromFile(tempFile);
        return uri;
    }
}
