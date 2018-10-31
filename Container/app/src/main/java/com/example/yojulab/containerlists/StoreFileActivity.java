package com.example.yojulab.containerlists;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StoreFileActivity extends AppCompatActivity implements View.OnClickListener {

    String FILENAME = "storeFile.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_file);

        Button buttonFileReadFromInner = findViewById(R.id.buttonFileReadFromInner);
        Button buttonFileWriteFromInner = findViewById(R.id.buttonFileWriteFromInner);
        Button buttonFileReadFromPrivateOutter = findViewById(R.id.buttonFileReadFromPrivateOutter);
        Button buttonFileWriteFromPrivateOutter = findViewById(R.id.buttonFileWriteFromPrivateOutter);
        Button buttonFileReadFromPublicOutter = findViewById(R.id.buttonFileReadFromPublicOutter);
        Button buttonFileWriteFromPublicOutter = findViewById(R.id.buttonFileWriteFromPublicOutter);

        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED) == false) {
            Toast.makeText(this, "False External Store", Toast.LENGTH_SHORT);
        } else {
            buttonFileReadFromInner.setOnClickListener(this);
            buttonFileWriteFromInner.setOnClickListener(this);
            buttonFileReadFromPrivateOutter.setOnClickListener(this);
            buttonFileWriteFromPrivateOutter.setOnClickListener(this);
            buttonFileReadFromPublicOutter.setOnClickListener(this);
            buttonFileWriteFromPublicOutter.setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View view) {
        EditText editTextInput = findViewById(R.id.editTextInput);

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        File file = null;

        switch (view.getId()) {
            case R.id.buttonFileReadFromInner:
                try {
                    fileInputStream = openFileInput(FILENAME);
                    byte[] buffer = new byte[fileInputStream.available()];
                    fileInputStream.read(buffer);
                    editTextInput.setText(new String(buffer));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case R.id.buttonFileWriteFromInner:
                try {
                    fileOutputStream = openFileOutput(FILENAME, Context.MODE_PRIVATE);
                    fileOutputStream.write(editTextInput.getText().toString().getBytes());
                    editTextInput.setText("");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case R.id.buttonFileReadFromPrivateOutter:
                try {
                    file = new File(getExternalFilesDir(null), FILENAME);
                    fileInputStream = new FileInputStream(file);
                    byte[] buffer = new byte[fileInputStream.available()];
                    fileInputStream.read(buffer);
                    editTextInput.setText(new String(buffer));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case R.id.buttonFileWriteFromPrivateOutter:
                try {
                    file = new File(getExternalFilesDir(null), FILENAME);

                    fileOutputStream = new FileOutputStream(file);
                    fileOutputStream.write(editTextInput.getText().toString().getBytes());
                    editTextInput.setText("");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case R.id.buttonFileReadFromPublicOutter:
                try {
                    file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), FILENAME);
                    fileInputStream = new FileInputStream(file);
                    byte[] buffer = new byte[fileInputStream.available()];
                    fileInputStream.read(buffer);
                    editTextInput.setText(new String(buffer));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case R.id.buttonFileWriteFromPublicOutter:
                try {
                    file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), FILENAME);

                    fileOutputStream = new FileOutputStream(file);
                    fileOutputStream.write(editTextInput.getText().toString().getBytes());
                    editTextInput.setText("");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }
}
