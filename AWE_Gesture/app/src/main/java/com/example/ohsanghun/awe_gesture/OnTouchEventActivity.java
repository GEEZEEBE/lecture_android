package com.example.ohsanghun.awe_gesture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class OnTouchEventActivity extends AppCompatActivity {

    TextView touchOneStatus = null;
    TextView touchTwoStatus = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_touch_event);
        LinearLayout gestureLayout = (LinearLayout) findViewById(R.id.gestureGround);

        gestureLayout.setOnTouchListener(touchListener);

        touchOneStatus = (TextView) findViewById(R.id.touchOneStatus);
        touchTwoStatus = (TextView) findViewById(R.id.touchTwoStatus);
    }

    RelativeLayout.OnTouchListener touchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            handleTouch(event);
            return true;
        }
    };

    private void handleTouch(MotionEvent event) {
        int pointerCnt = event.getPointerCount();

        int i, x, y, id, action, actionIndex ;
        String actionStr = null, touchStatus = null;
        for(i=0; i<pointerCnt; i++){
            x = (int) event.getX(i);
            y = (int) event.getY(i);
            id = event.getPointerId(i);
            action = event.getActionMasked();
            actionIndex = event.getActionIndex();

            switch (action){
                case MotionEvent.ACTION_DOWN:
                    actionStr = "ACTION_DOWN";
                    break;
                case MotionEvent.ACTION_UP:
                    actionStr = "ACTION_UP";
                    break;
                case MotionEvent.ACTION_POINTER_DOWN:
                    actionStr = "ACTION_POINTER_DOWN";
                    break;
                case MotionEvent.ACTION_POINTER_UP:
                    actionStr = "ACTION_POINTER_UP";
                    break;
                case MotionEvent.ACTION_MOVE:
                    actionStr = "ACTION_MOVE";
                    break;
                case MotionEvent.ACTION_HOVER_MOVE:
                    actionStr = "ACTION_HOVER_MOVE";
                    break;
            }

            touchStatus = "Action : " + actionStr + ", Index : " + actionIndex +
                    "\n" + " ID : " + id + ", x : " + x + ", y : " + y ;

            if (id == 0){
                touchOneStatus.setText(touchStatus);
            } else {
                touchTwoStatus.setText(touchStatus);
            }
        }
    }
}
