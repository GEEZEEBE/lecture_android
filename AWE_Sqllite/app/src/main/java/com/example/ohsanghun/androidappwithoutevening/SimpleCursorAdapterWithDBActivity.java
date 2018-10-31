package com.example.ohsanghun.androidappwithoutevening;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.idescout.sql.SqlScoutServer;

public class SimpleCursorAdapterWithDBActivity extends AppCompatActivity implements View.OnClickListener {

    MyDBOpenHelper dbHelper;
    SQLiteDatabase mdb;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_cursor_adapter_with_db);

        dbHelper = new MyDBOpenHelper(this, "awe.db", null, 2);
        try {
            mdb = dbHelper.getWritableDatabase();
        } catch (SQLiteException ex) {
            mdb = dbHelper.getReadableDatabase();
        }

        findViewById(R.id.btnInsert).setOnClickListener(this);
        findViewById(R.id.btnRead).setOnClickListener(this);
        findViewById(R.id.btnUpdate).setOnClickListener(this);
        findViewById(R.id.btnDelete).setOnClickListener(this);

        tv = (TextView) findViewById(R.id.edit);
    }

    @Override
    public void onClick(View view) {
        ContentValues row;
        Cursor cursor;
        int id;

        EditText countryEditText = (EditText) findViewById(R.id.country);
        EditText cityEditText = (EditText) findViewById(R.id.city);

        String country = "";
        String capital = "";
        switch (view.getId()) {
            case R.id.btnInsert:

                country = countryEditText.getText().toString();
                capital = cityEditText.getText().toString();


                mdb.execSQL("INSERT INTO awe_country VALUES( null, '" + country + "', '" + capital + "');");
                break;
            case R.id.btnRead:
                cursor = mdb.rawQuery("SELECT * FROM awe_country", null);

                if (cursor.moveToNext()) {
                    startManagingCursor(cursor);
                    String[] from = {"country", "capital"};
                    int[] to = {android.R.id.text1, android.R.id.text2};

                    SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, cursor, from, to);
                    ListView listView = findViewById(R.id.listView);
                    listView.setAdapter(simpleCursorAdapter);
                } else {
                    Toast.makeText(view.getContext(), "Warning Empty DB", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btnUpdate:
                cursor = mdb.rawQuery("SELECT * FROM awe_country", null);
                cursor.moveToFirst();
                id = cursor.getInt(0);
//                    String Args = [id];
                mdb.execSQL("UPDATE awe_country SET capital='aaa' WHERE _id=" + id + ";");
                break;
            case R.id.btnDelete:
                dbHelper.deleteRecord(mdb, countryEditText.getText().toString());
                Toast.makeText(getApplicationContext(), "Delete Record", Toast.LENGTH_LONG).show();
                break;
        }
//				cursor.close();
    }
}
