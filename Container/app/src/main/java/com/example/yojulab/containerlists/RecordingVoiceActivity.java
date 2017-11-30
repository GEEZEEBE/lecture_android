package com.example.yojulab.containerlists;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class RecordingVoiceActivity extends AppCompatActivity {

    private MediaRecorder mediaRecorder;

    File outputFile = null;
    private View audioRecordStart;
    private View audioRecordStop;
    private View audioPlay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recording_voice);
    }

    public void onClickRecordStart(View v) {
        audioRecordStart.setEnabled(false);
        audioPlay.setEnabled(true);

        File sampleDir = Environment.getExternalStorageDirectory();

        try {
            outputFile = File.createTempFile("sound", ".3gp", sampleDir);
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "SD Card Access Error", Toast.LENGTH_LONG).show();
//            Log.e(TAG, "Sdcard access error");
            return;
        }

        mediaRecorder = new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        mediaRecorder.setAudioEncodingBitRate(16);
        mediaRecorder.setAudioSamplingRate(44100);
        mediaRecorder.setOutputFile(outputFile.getAbsolutePath());
        try {
            mediaRecorder.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaRecorder.start();
    }

    public void onClickRecordStop(View v) {
        audioRecordStop.setEnabled(false);
        audioPlay.setEnabled(true);
        mediaRecorder.stop();
        mediaRecorder.release();
        mediaRecorder = null;
    }

    public void onClickPlay(View v) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setDataSource(String.valueOf(outputFile));
        mediaPlayer.prepare();
        mediaPlayer.start();
    }
}
