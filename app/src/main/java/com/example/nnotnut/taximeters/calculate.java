package com.example.nnotnut.taximeters;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import static com.example.nnotnut.taximeters.MyDbHelper.SHORTWAY;

/**
 * Created by N'NotNut on 18-Nov-16.
 */

public class calculate {
    SQLiteDatabase mDb;
    MyDbHelper mHelper;
    Cursor cursor ;
    Double result = 0.0;
    public static final String KEY_SHORTWAY = "SHORTWAY";
    public static final String KEY_LONGWAY =  "LONGWAY" ;
    public static final String KEY_RATE_SER =  "RATE_SER" ;

    private static final String[] COLUMNS = {KEY_SHORTWAY,KEY_LONGWAY,KEY_RATE_SER};





    public double getservice(int id,String shortway,String longway){

        mDb = mHelper.getReadableDatabase();

        cursor =  mDb.query(mHelper.TABLE_NAME, // a. table
                COLUMNS, // b. column names
                " id = ?", // c. selections
                new String[] { String.valueOf(id) }, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit
        if (cursor != null)
            cursor.moveToFirst();

//        result = Double.valueOf(cursor.getString(3));




        return result;
    }
}
