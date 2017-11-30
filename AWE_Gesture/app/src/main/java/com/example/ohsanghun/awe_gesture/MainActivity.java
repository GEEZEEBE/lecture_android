package com.example.ohsanghun.awe_gesture;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){
        int id = view.getId();
        Class<?> cls = null;
        Intent intent;
        switch (id){
            case R.id.OnTouchEventButton:
                cls = OnTouchEventActivity.class;
                break;
            case R.id.gesturedetector:
                cls = GestureDetectorActivity.class;
                break;
            case R.id.scaleGestureDetectorButton:
                cls = ScaleGestureDetectorActivity.class;
                break;
            case R.id.dragAndDropGestureButton:
                cls = DragDropGestureActivity.class;
                break;
        }
        intent = new Intent(view.getContext(), cls);
        startActivity(intent);
    }
}