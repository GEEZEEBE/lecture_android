package com.example.ohsanghun.androidappwithoutevening;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.idescout.sql.SqlScoutServer;

public class RelativeDataBaseActivity extends AppCompatActivity {

    RelativeDBOpenHelper dbHelper;
    SQLiteDatabase mdb;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_database);

        dbHelper = new RelativeDBOpenHelper(this);
        try {
            mdb = dbHelper.getWritableDatabase();
        } catch (SQLiteException ex) {
            mdb = dbHelper.getReadableDatabase();
        }

        findViewById(R.id.btnInsert).setOnClickListener(mListener);
        findViewById(R.id.btnRead).setOnClickListener(mListener);
        findViewById(R.id.btnUpdate).setOnClickListener(mListener);
        findViewById(R.id.btnDelete).setOnClickListener(mListener);
        findViewById(R.id.buttonSearch).setOnClickListener(mListener);
        findViewById(R.id.buttonAddVisitedRecord).setOnClickListener(mListener);

        tv = (TextView) findViewById(R.id.edit);
    }

    View.OnClickListener mListener = new View.OnClickListener() {

        ContentValues row;
        Cursor cursor;
        @Override
        public void onClick(View v) {

            EditText editTextPkID = (EditText) findViewById(R.id.editTextPkID);
            EditText countryEditText = (EditText) findViewById(R.id.country);
            EditText cityEditText = (EditText) findViewById(R.id.city);
            EditText editTextVisitedTotal = (EditText) findViewById(R.id.editTextVisitedTotal);

            String strPkID = null;
            String country = null;
            String capital = null;
            int visitedTotal = 0;

            String query = null;

            switch (v.getId()) {
                case R.id.btnInsert:

                    country = countryEditText.getText().toString();
                    capital = cityEditText.getText().toString();

                    CommonUtil commonUtil = new CommonUtil();
                    strPkID = commonUtil.getUniqueSequence();

                    mdb.execSQL("INSERT INTO awe_country VALUES( '" + strPkID + "', '" + country + "', '" + capital + "');");
                    break;
                case R.id.btnRead:
                    cursor = mdb.rawQuery("SELECT * FROM awe_country", null);
                    String str = "";
                    while (cursor.moveToNext()) {
                        strPkID = cursor.getString(0);
                        country = cursor.getString(cursor.getColumnIndex("country"));
                        capital = cursor.getString(2);
                        str += (strPkID + " : " + country + " - " + capital + "\n");
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
                    country = cursor.getString(cursor.getColumnIndex("country"));
                    mdb.execSQL("UPDATE awe_country SET capital='aaa' WHERE country='" + country + "';");
                    break;
                case R.id.btnDelete:
                    dbHelper.deleteRecord(mdb, countryEditText.getText().toString());
                    Toast.makeText(getApplicationContext(), "Delete Record", Toast.LENGTH_LONG).show();
                    break;
                case R.id.buttonAddVisitedRecord:
                    strPkID = editTextPkID.getText().toString();

                    query = "INSERT INTO awe_country_visitedcount VALUES('" + strPkID + "')";
                    mdb.execSQL(query);
                    break;
                case R.id.buttonSearch:
                    country = countryEditText.getText().toString();

                    query = "SELECT pkid, country, capital, count(fkid) visitedTotal" +
                            "FROM awe_country " +
                            "INNER JOIN awe_country_visitedcount " +
                            "ON pkid = fkid " +
                            "AND pkid = '" + country + "' ";
                    cursor = mdb.rawQuery(query, null);

                    if (cursor.getCount() > 0) {
                        cursor.moveToFirst();
                        strPkID = cursor.getString(cursor.getColumnIndex("pkid"));
                        country = cursor.getString(cursor.getColumnIndex("country"));
                        capital = cursor.getString(cursor.getColumnIndex("capital"));
                        visitedTotal = cursor.getInt(cursor.getColumnIndex("visitedTotal"));

                        editTextPkID.setText(strPkID);
                        countryEditText.setText(country);
                        cityEditText.setText(capital);
                        editTextVisitedTotal.setText(String.valueOf(visitedTotal));

                    } else {
                        Toast.makeText(getApplicationContext(), "Warning Empty DB", Toast.LENGTH_LONG).show();
                        tv.setText("");
                    }
                    break;
                case R.id.buttonSearchWithCountryNotJoin:
                    country = countryEditText.getText().toString();

                    query = "SELECT * FROM awe_country WHERE country='" + country + "' ";
                    cursor = mdb.rawQuery(query, null);

                    if (cursor.getCount() > 0) {
                        cursor.moveToFirst();
                        strPkID = cursor.getString(cursor.getColumnIndex("pkid"));
                        country = cursor.getString(cursor.getColumnIndex("country"));
                        capital = cursor.getString(cursor.getColumnIndex("capital"));

                        query = "SELECT count(*) visitedTotal FROM awe_country_visitedcount WHERE fkid = '" + strPkID + "' ";
                        cursor = mdb.rawQuery(query, null);
                        cursor.moveToFirst();
                        visitedTotal = cursor.getInt(cursor.getColumnIndex("visitedTotal"));

                        editTextPkID.setText(strPkID);
                        countryEditText.setText(country);
                        cityEditText.setText(capital);
                        editTextVisitedTotal.setText(String.valueOf(visitedTotal));

                    } else {
                        Toast.makeText(getApplicationContext(), "Warning Empty DB", Toast.LENGTH_LONG).show();
                        tv.setText("");
                    }
                    break;
            }
//            cursor.close();
        }
    };
}

