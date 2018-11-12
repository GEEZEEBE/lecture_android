package com.yojulab.deviceandsensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorEventListener2;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class PedometerActivity extends AppCompatActivity implements SensorEventListener2, SeekBar.OnSeekBarChangeListener {

    private TextView textViewGx, textViewGy, textViewGz;
    private TextView textViewSteps;

    Button buttonResetCounter;

    private SensorManager sensorManager;
    private float acceleration, previousY, currentY;
    private int steps;

    int threshold = 0;
    SeekBar seekBarSensitive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedometer);

        textViewGx = findViewById(R.id.textViewGx);
        textViewGy = findViewById(R.id.textViewGy);
        textViewGz = findViewById(R.id.textViewGz);

        textViewSteps = findViewById(R.id.textViewSteps);
        seekBarSensitive = findViewById(R.id.seekBarSensitive);
        seekBarSensitive.setProgress(10);
        seekBarSensitive.setOnSeekBarChangeListener(this);

        previousY = currentY = steps = 0;

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
//        sensorManager.registerListener(this, )

    }

    @Override
    public void onFlushCompleted(Sensor sensor) {

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
