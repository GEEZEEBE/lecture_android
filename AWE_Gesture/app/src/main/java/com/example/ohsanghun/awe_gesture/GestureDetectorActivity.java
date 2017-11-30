package com.example.ohsanghun.awe_gesture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;

public class GestureDetectorActivity extends AppCompatActivity
        implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener{

    TextView gestureTextView;
    private  GestureDetector gestureDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture_detector);

        gestureTextView = (TextView) findViewById(R.id.gestureTextView);

        this.gestureDetector = new GestureDetector(this, this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        this.gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        gestureTextView.setText("onDown");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        gestureTextView.setText("onShowPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        gestureTextView.setText("onSingleTapUp");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        gestureTextView.setText("onScroll");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        gestureTextView.setText("onLongPress");

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        gestureTextView.setText("onFling");
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        gestureTextView.setText("onSingleTapConfirmed");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        gestureTextView.setText("onDoubleTap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        gestureTextView.setText("onDoubleTapEvent");
        return true;
    }
}
