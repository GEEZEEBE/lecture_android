package com.example.ohsanghun.awe_gesture;

import android.content.ClipData;
import android.content.ClipDescription;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class DragDropGestureActivity extends AppCompatActivity{

    float eventX ;
    float eventY ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_drop_gesture);
        //set ontouch listener for box views
        findViewById(R.id.box_view1).setOnTouchListener(onTouchListener);
        findViewById(R.id.box_view2).setOnTouchListener(onTouchListener);
        findViewById(R.id.box_view3).setOnTouchListener(onTouchListener);
        findViewById(R.id.box_view4).setOnTouchListener(onTouchListener);

        //set ondrag listener for right and left parent views
        findViewById(R.id.box_view1).setOnDragListener(onDragListener);
        findViewById(R.id.box_view2).setOnDragListener(onDragListener);
        findViewById(R.id.box_view3).setOnDragListener(onDragListener);
        findViewById(R.id.box_view4).setOnDragListener(onDragListener);

        findViewById(R.id.left_view).setOnDragListener(onDragListener);
        findViewById(R.id.right_view).setOnDragListener(onDragListener);
    }

    View.OnTouchListener onTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent event) {
            if(event.getAction() == MotionEvent.ACTION_DOWN){
                eventX = view.getX();
                eventY = view.getY();
                Log.d("DragEvent", "onTouch - X : " + eventX + ",Y : " + eventY);
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                shadowBuilder.getView().setAlpha(1);
                view.startDrag(data, shadowBuilder, view, 0);
                view.setVisibility(View.INVISIBLE);
                return true;
            }
            return false;
        }
    };


    View.OnDragListener onDragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            eventX = event.getX();
            eventY = event.getY();
            Log.d("DragEvent", "X : " + eventX + ",Y : " + eventY);

            if(event.getAction()==DragEvent.ACTION_DROP){
                //we want to make sure it is dropped only to left and right parent view
                View view = (View)event.getLocalState();

                if(v.getId() == R.id.left_view || v.getId() == R.id.right_view){

                    ViewGroup source = (ViewGroup) view.getParent();
                    source.removeView(view);

                    LinearLayout target = (LinearLayout) v;
                    target.addView(view);
                }
                //make view visible as we set visibility to invisible while starting drag
                view.setVisibility(View.VISIBLE);
            }
            return true;
        }
    };
}
