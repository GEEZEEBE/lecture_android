package com.example.ohsanghun.awe_widget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static android.support.v7.appcompat.R.styleable.View;

public class EditTextActivity extends AppCompatActivity {

    EditText plainText ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);

        plainText = (EditText) findViewById(R.id.plainText);

        plainText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    Toast.makeText(v.getContext(),((EditText)v).getText().toString(),Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });
    }

}
