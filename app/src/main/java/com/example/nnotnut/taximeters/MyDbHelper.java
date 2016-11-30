package com.example.nnotnut.taximeters;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.renderscript.Double2;



public class MyDbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "Rate1.db";
    private static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "Rate";
    public static final String SHORTWAY = "SHORTWAY";
    public static final String LONGWAY =  "LONGWAY" ;
    public static final String RATE_SER =  "RATE_SER" ;

    public MyDbHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
//        SQLiteDatabase db = this.getWritableDatabase();
}
    @Override
    public void onCreate(SQLiteDatabase db) {
//        db = this.getWritableDatabase();
        db.execSQL("CREATE TABLE "+TABLE_NAME  +"(_id INTEGER PRIMARY KEY AUTOINCREMENT,"+SHORTWAY +" TEXT," +LONGWAY+" TEXT, "+RATE_SER+" TEXT); ");
//        insert("1","10","5.5");
//        db.execSQL("CREATE TABLE "+TABLE_NAME  +"("+SHORTWAY +"TEXT," +LONGWAY+"TEXT, "+RATE_SER+"TEXT) ");
//        ContentValues ct = new ContentValues();
//        ct.put(SHORTWAY,"1");
//        ct.put(LONGWAY,"10");
//        ct.put(RATE_SER,"5.5");
//        db.insert(TABLE_NAME, null,ct);
        db.execSQL("INSERT INTO "+TABLE_NAME+"("+SHORTWAY+","+LONGWAY+","+RATE_SER+") VALUES('0','1','35');");
        db.execSQL("INSERT INTO "+TABLE_NAME+"("+SHORTWAY+","+LONGWAY+","+RATE_SER+") VALUES('0','10','5.5');");
        db.execSQL("INSERT INTO "+TABLE_NAME+"("+SHORTWAY+","+LONGWAY+","+RATE_SER+") VALUES('10','20','6.5');");
        db.execSQL("INSERT INTO "+TABLE_NAME+"("+SHORTWAY+","+LONGWAY+","+RATE_SER+") VALUES('20','40','7.5');");
        db.execSQL("INSERT INTO "+TABLE_NAME+"("+SHORTWAY+","+LONGWAY+","+RATE_SER+") VALUES('40','60','8');");
        db.execSQL("INSERT INTO "+TABLE_NAME+"("+SHORTWAY+","+LONGWAY+","+RATE_SER+") VALUES('60','80','9');");
        db.execSQL("INSERT INTO "+TABLE_NAME+"("+SHORTWAY+","+LONGWAY+","+RATE_SER+") VALUES('80','10000','10.5');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        onCreate(db);
    }
//    public void insert(String shortway , String longway , String rate){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues ct = new ContentValues();
//        ct.put(SHORTWAY,shortway);
//        ct.put(LONGWAY,longway);
//        ct.put(RATE_SER,rate);
//        long result = db.insert(TABLE_NAME,null,ct);
//        if(result == -1) {
//            return false;
//        }
//        else{
//            return true;
//        }
//    }

//    public boolean insertData(String shortway,String longway,String rate_ser) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(SHORTWAY,shortway);
//        contentValues.put(LONGWAY,longway);
//        contentValues.put(RATE_SER,rate_ser);
//        long result = db.insert(TABLE_NAME,null ,contentValues);
//        if(result == -1)
//            return false;
//        else
//            return true;
//    }
//
//    public Cursor getAllData() {
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
//        return res;
//    }
//
//    public boolean updateData(String id,String shortway,String longway,String rate_ser) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
////        contentValues.put(COL_1,id);
//        contentValues.put(SHORTWAY,shortway);
//        contentValues.put(LONGWAY,longway);
//        contentValues.put(RATE_SER,rate_ser);
//        db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { id });
//        return true;
//    }
//
//    public Integer deleteData (String id) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        return db.delete(TABLE_NAME, "ID = ?",new String[] {id});
//    }


//public double getservice(int id,String shortway,String longway){
//
//    mDb = mHelper.getReadableDatabase();
//
//    cursor =  mDb.query(mHelper.TABLE_NAME, // a. table
//            COLUMNS, // b. column names
//            " id = ?", // c. selections
//            new String[] { String.valueOf(id) }, // d. selections args
//            null, // e. group by
//            null, // f. having
//            null, // g. order by
//            null); // h. limit
//    if (cursor != null)
//        cursor.moveToFirst();
//
////        result = Double.valueOf(cursor.getString(3));
//
//
//
//
//    return result;
//}
public Cursor getAllData() {
    SQLiteDatabase db = this.getWritableDatabase();
    Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
    return res;
}



}
