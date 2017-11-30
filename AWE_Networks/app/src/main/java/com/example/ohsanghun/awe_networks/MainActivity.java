package com.example.ohsanghun.awe_networks;

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

    public void onClickNetwork(View view){
        int id = view.getId();
        Intent intent = null;
        String text = ((Button) view).getText().toString();
        Bundle bundle = new Bundle();
        Class<?> cls = null;
        switch (id) {
            case R.id.getBTListButton:
                cls = GetBTListActivity.class;
                break;
            case R.id.connectBTButton:
                cls = ConnectBTActivity.class;
                break;
            case R.id.bluetoothCommunicateWithArduino:
                cls = BluetoothCommunicateWithArduinoActivity.class;
                break;
            case R.id.restApiMissingButton:
                cls = RestAPIActivity.class;
                break;
            case R.id.restApiButton:
                cls = com.example.ohsanghun.awe_networks_tmp.RestAPIActivity.class;
                break;
        }
        intent = new Intent(this, cls);
        startActivity(intent);
    }
}
