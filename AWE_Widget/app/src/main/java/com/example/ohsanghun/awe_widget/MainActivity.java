package com.example.ohsanghun.awe_widget;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickWidget(View view) {
        int id = view.getId();
        Intent intent = null;
        String text = ((Button) view).getText().toString();
        Bundle bundle = new Bundle();
        Class<?> cls = null;
        switch (id) {
            case R.id.textviewWidget:
                cls = TextViewActivity.class;
                break;
            case R.id.buttonWidget:
                cls = ButtonActivity.class;
                break;
            case R.id.checkboxWidget:
                cls = CheckBoxActivity.class;
                break;
            case R.id.radiobutton:
                cls = RadioButtonActivity.class;
                break;
            case R.id.ratingBarWidget:
                cls = RatingBarActivity.class;
                break;
            case R.id.switchWidget:
                cls = SwitchActivity.class;
                break;
            case R.id.spinnerWidget:
                cls = SpinnerActivity.class;
                break;
            case R.id.progressBarWidget:
                cls = ProgressBarActivity.class;
                break;
            case R.id.seekBarWidget:
                cls = SeekBarActivity.class;
                break;
            case R.id.editTextWidget:
                cls = EditTextActivity.class;
                break;
            case R.id.quickContactBadgeWidget:
                cls = QuickContactBadgeActivity.class;
                break;
            default:
                cls = MainActivity.class;
        }

        // Storing bundle object into intent
        bundle.putString("bundleName", text);

        intent = new Intent(this, cls);
        intent.putExtras(bundle);

        // Result from sub Activity
        startActivityForResult(intent, Activity.RESULT_FIRST_USER);
    }

}
