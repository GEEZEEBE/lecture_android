package com.example.ohsanghun.awe_event;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onClickAndroidActivity(View view) {
        Toast.makeText(this, "Click AndroidonClickActivity!", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(getApplicationContext(), AndroidonClickActivity.class);
        startActivity(intent);
    }

    public void onClickActivity(View view) {
        int id = view.getId();
        CharSequence text = null;
        Intent intent = null;
        switch (id) {
            case R.id.button6:
                text = "Click activity_implements_view_on_click_listener!";
                intent = new Intent(this, implementsViewOnClickListenerActivity.class);
                break;
            case R.id.button9:
                text = "Click activity_anonymousclass_set_on_click_listener!";
                intent = new Intent(getApplicationContext(), AnonymousClassSetOnClickListenerActivity.class);
                break;
            case R.id.button8:
                text = "Click activity_anonymousclass_set_on_click_listener!";
                intent = new Intent(view.getContext(), LambdaSetOnClickListenerActivity.class);
                break;
            default:
                text = "Click AndroidonClickActivity!";
                intent = new Intent(this, AndroidonClickActivity.class);
        }
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        startActivity(intent);
    }

}
