package com.example.ohsanghun.awe_widget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.Toast;

import static com.example.ohsanghun.awe_widget.R.id.seekBar01;

public class SeekBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar);

        SeekBar seekBar01 = (SeekBar) findViewById(R.id.seekBar01);
        SeekBar seekBar02 = (SeekBar) findViewById(R.id.seekBar02);

        seekBar01.setProgress(0);
        seekBar01.setOnSeekBarChangeListener(seekBarListener);
        seekBar02.setOnSeekBarChangeListener(seekBarListener);
    }

    SeekBar.OnSeekBarChangeListener seekBarListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
            Toast.makeText(getApplicationContext(), seekBar.getId() + "-" + String.valueOf(progress),Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            Toast.makeText(getApplicationContext(), seekBar.getId() + "-onStartTrackingTouch", Toast.LENGTH_SHORT).show() ;
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            Toast.makeText(getApplicationContext(), seekBar.getId() + "-onStopTrackingTouch", Toast.LENGTH_SHORT).show() ;
        }
    };
}
