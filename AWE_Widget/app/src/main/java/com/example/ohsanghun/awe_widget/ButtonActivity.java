package com.example.ohsanghun.awe_widget;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class ButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
    }

    public void onClickWidget(View view) {
        int id = view.getId();
        String text = null;
        switch (id) {
            case R.id.buttonToast:
                text = ((Button)view).getText().toString();
                break;
            case R.id.imageButton:
                text = "imageButton";
                break;
            default:
                text = "Noting!";
        }
        Toast.makeText(view.getContext(), text, Toast.LENGTH_SHORT).show();
    }

}
