package com.example.ohsanghun.androidappwithoutevening;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class RelativeDBOpenHelper extends SQLiteOpenHelper {
    private static final String name = "awe_relative.db";
    private static final SQLiteDatabase.CursorFactory factory = null;
    private static final int version = 6;

    public RelativeDBOpenHelper(Context context) {
        super(context, name, factory, version);
    }

    public RelativeDBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                                int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE awe_country (pkid TEXT PRIMARY KEY, country TEXT, capital TEXT);");
        db.execSQL("CREATE TABLE awe_country_visitedcount (fkid TEXT);");

        CommonUtil commonUtil = new CommonUtil();
        String strPkID = null;
        for(int i=0; i<5; i++){
            strPkID = commonUtil.getUniqueSequence();
            db.execSQL("INSERT INTO awe_country VALUES('" + strPkID+ "', '" + "Country"+ i + "', '" + "Capital" + i + "');");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE awe_country ;");
        db.execSQL("DROP TABLE awe_country_visitedcount ;");
        onCreate(db);
//        Toast.makeText(this.,"onUpgrade", Toast.LENGTH_LONG).show();
    }

    public void deleteRecord(SQLiteDatabase mdb, String country) {
        mdb.execSQL("DELETE FROM awe_country WHERE country='" + country + "';");
    }

}
