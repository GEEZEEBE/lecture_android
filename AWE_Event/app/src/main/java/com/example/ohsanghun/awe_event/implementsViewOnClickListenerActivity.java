package com.example.ohsanghun.awe_event;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class implementsViewOnClickListenerActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn1, btn2, btn3, btn4, btn5, btn6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implements_view_on_click_listener);

        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);
        btn6 = (Button)findViewById(R.id.btn6);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String msg = null;

        if(v.getId() == R.id.btn1){
            Toast.makeText(this, "onClickButton01", Toast.LENGTH_LONG).show();
        }else if(v.getId() == R.id.btn2){
            Toast.makeText(this, "onClickButton02", Toast.LENGTH_LONG).show();
        }else if(v.getId() == R.id.btn3){
            Toast.makeText(this, "onClickButton03", Toast.LENGTH_LONG).show();
        }else if(v.getId() == R.id.btn4){
            Toast.makeText(this, "onClickButton04", Toast.LENGTH_LONG).show();
        }else if(v.getId() == R.id.btn5){
            Toast.makeText(this, "onClickButton05", Toast.LENGTH_LONG).show();
        }else if(v.getId() == R.id.btn6){
            Toast.makeText(this, "onClickButton06", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "onClickButton07", Toast.LENGTH_LONG).show();
        }

    }
}
