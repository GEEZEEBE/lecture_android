package com.example.ohsanghun.androidappwithoutevening;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.idescout.sql.SqlScoutServer;

public class MainActivity extends AppCompatActivity {

    MyDBOpenHelper dbHelper;
    SQLiteDatabase mdb;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SqlScoutServer.create(this, getPackageName());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new MyDBOpenHelper(this, "awe.db", null, 5);
        mdb = dbHelper.getWritableDatabase();

        findViewById(R.id.btnInsert).setOnClickListener(mListener);
        findViewById(R.id.btnRead).setOnClickListener(mListener);
        findViewById(R.id.btnUpdate).setOnClickListener(mListener);
        findViewById(R.id.btnDelete).setOnClickListener(mListener);

        tv = (TextView) findViewById(R.id.edit);
    }

    View.OnClickListener mListener = new View.OnClickListener() {

        ContentValues row;
        Cursor cursor;
        int id;

        @Override
        public void onClick(View v) {

            EditText countryEditText = (EditText) findViewById(R.id.country);
            EditText cityEditText = (EditText) findViewById(R.id.city);

            String country = "";
            String capital = "";
            switch (v.getId()) {
                case R.id.btnInsert:

                    country = countryEditText.getText().toString();
                    capital = cityEditText.getText().toString();


                    mdb.execSQL("INSERT INTO awe_country VALUES( null, '" + country + "', '" + capital + "');");
                    break;
                case R.id.btnRead:
                    cursor = mdb.rawQuery("SELECT * FROM awe_country", null);
                    String str = "";
                    while (cursor.moveToNext()) {
                        id = cursor.getInt(0);
                        country = cursor.getString(1);
                        capital = cursor.getString(2);
                        str += (id + " : " + country + " - " + capital + "\n");
                    }
                    if (str.length() > 0) {
                        tv.setText(str);
                    } else {
                        Toast.makeText(getApplicationContext(), "Warning Empty DB", Toast.LENGTH_LONG).show();
                        tv.setText("");
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
    };
}

class MyDBOpenHelper extends SQLiteOpenHelper {

    public MyDBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                          int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE awe_country (_id INTEGER PRIMARY KEY AUTOINCREMENT, country TEXT, capital TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        Toast.makeText(this.,"onUpgrade", Toast.LENGTH_LONG).show();
    }

    public void deleteRecord(SQLiteDatabase mdb, String country) {
        mdb.execSQL("DELETE FROM awe_country WHERE country='" + country + "';");
    }

}
