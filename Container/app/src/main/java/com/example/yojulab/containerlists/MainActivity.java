package com.example.yojulab.containerlists;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickContainer(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.buttonStoreFile:
                intent = new Intent(getApplicationContext(), StoreFileActivity.class);
                break;
            case R.id.listviewButton:
                intent = new Intent(getApplicationContext(), ListViewSingleColumnActivity.class);
                break;
            case R.id.listviewMultiColumnButton:
                intent = new Intent(getApplicationContext(), ListViewMultiColumnActivity.class);
                break;
            case R.id.webviewExplicitButton:
                intent = new Intent(getApplicationContext(), WebViewExplicitActivity.class);
                break;
            case R.id.webviewSimpleButton:
                intent = new Intent(getApplicationContext(), WebViewSimpleActivity.class);
                break;
            case R.id.webviewImplicitButton:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://blog.naver.com/otter35"));
                break;
            case R.id.videoViewFromGalleryButton:
                intent = new Intent(getApplicationContext(), VideoViewFromGalleryActivity.class);
                break;
            case R.id.videoviewSimpleButton:
                intent = new Intent(getApplicationContext(), VideoViewSimpleActivity.class);
                break;
            case R.id.videoviewMediaControllerButton:
                intent = new Intent(getApplicationContext(), VideoViewMediaControllerActivity.class);
                break;
            case R.id.videoviewTakeCameraButton:
                intent = new Intent(getApplicationContext(), VideoViewTakeCameraActivity.class);
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
