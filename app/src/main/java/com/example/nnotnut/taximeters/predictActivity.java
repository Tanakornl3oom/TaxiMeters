//package com.example.nnotnut.taximeters;
//
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v7.app.AppCompatActivity;
//import android.view.Window;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//
//import java.util.ArrayList;
//
///**
// * Created by N'NotNut on 17-Nov-16.
// */
//
//public class predictActivity extends AppCompatActivity {
//    SQLiteDatabase mDb;
//    MyDbHelper mHelper;
//    Cursor mCursor;
//
//    @Override
//    protected void onCreate( Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        setContentView(R.layout.predict);
//
////        ListView listView1 = (ListView)findViewById(R.layout.listView1);
//
//        mHelper = new MyDbHelper(this);
//        mDb = mHelper.getWritableDatabase();
//        mCursor = mDb.rawQuery("SELECT " + MyDbHelper.SHORTWAY + ", "  + MyDbHelper.LONGWAY
//                + ", " + MyDbHelper.RATE_SER + " FROM " + MyDbHelper.TABLE_NAME, null);
//
//        ArrayList<String> dirArray = new ArrayList<String>();
//        mCursor.moveToFirst();
//
//        while ( !mCursor.isAfterLast() ){
//            dirArray.add("Shortway"+mCursor.getString(mCursor.getColumnIndex(MyDbHelper.SHORTWAY))
//                    + "Longway : " + mCursor.getString(mCursor.getColumnIndex(MyDbHelper.LONGWAY))
//                    + "Rate : " + mCursor.getString(mCursor.getColumnIndex(MyDbHelper.RATE_SER)));
//            mCursor.moveToNext();
//        }
//
//        ArrayAdapter<String> adapterDir = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dirArray);
////        listView1.setAdapter(adapterDir);
//    }
//
//    public void onPause() {
//        super.onPause();
//        mHelper.close();
//        mDb.close();
//    }
//}
//
