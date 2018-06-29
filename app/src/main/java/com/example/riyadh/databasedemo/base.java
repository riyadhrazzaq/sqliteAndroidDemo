package com.example.riyadh.databasedemo;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by riyadh on 28-Jun-18.
 */

public class base extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "db";
    private static final String TABLE_NAME = "col";
    private static final String col_reg = "reg";
    private static final String col_course = "courseId";
    private static final String col_mark = "mark";


    base(Context c){
        super(c,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase mydb) {
        String s= "CREATE TABLE "+TABLE_NAME+"("+col_reg+" INT PRIMARY KEY,"+col_course+" VARCHAR(10),"+col_mark+" FLOAT(4,2))";
        mydb.execSQL(s);
        Log.e("dbstat","database created successfully");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    // adding data to db

    public void addData( datatemp dt ){
        SQLiteDatabase sqdb  = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(col_reg,dt.getReg());
        cv.put(col_course,dt.getCourse());
        cv.put(col_mark,dt.getMark());
        sqdb.insert(TABLE_NAME,null,cv);

    }
    String [] getAll(){
        SQLiteDatabase sq = this.getReadableDatabase();

        String q = "SELECT * FROM "+TABLE_NAME;

        Cursor c = sq.rawQuery(q, null);

        String[] recvied_data = new String[c.getCount()];

        int i = 0;
        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            recvied_data[i++]= c.getString( c.getColumnIndex(col_reg) )+" | Course: "+c.getString(c.getColumnIndex(col_course))+" | Mark: "+
                    c.getString(c.getColumnIndex(col_mark)) ;
        }

        return recvied_data;
    }

    String[] getByReg(int reg){
        SQLiteDatabase sq = this.getReadableDatabase();
        String q = "select * from "+TABLE_NAME+" where "+col_reg+" ="+reg;
        Cursor c = sq.rawQuery(q,null);
        String[] res  = new String[c.getCount()];
        int i = 0;
        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            res[i++]= c.getString( c.getColumnIndex(col_reg) )+" | Course: "+c.getString(c.getColumnIndex(col_course))+" | Mark: "+
                    c.getString(c.getColumnIndex(col_mark)) ;
        }
        return  res;

    }
    void removeAll(){

    }



}
