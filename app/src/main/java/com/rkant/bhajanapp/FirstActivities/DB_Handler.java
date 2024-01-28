package com.rkant.bhajanapp.FirstActivities;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB_Handler extends SQLiteOpenHelper {
    private static final String DB_NAME="favourite_bhajansDB";
    private static final int DB_VERSION=1;
    private static final String DB_TABLE_NAME="bhajans_table";
    private static final String SERIAL_NO="serial_no";
    private static final String BHAJAN_NAME="bhajan_name";
    public DB_Handler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query="CREATE TABLE "+DB_TABLE_NAME+" ("+
                SERIAL_NO+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                BHAJAN_NAME+" TEXT)";
        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+DB_TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
    public void addData(String str){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(BHAJAN_NAME,str);
        db.insert(DB_TABLE_NAME,null,contentValues);
        db.close();

    }
}
