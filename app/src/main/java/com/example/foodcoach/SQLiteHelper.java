package com.example.foodcoach;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class SQLiteHelper extends SQLiteOpenHelper {
    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public void queryData(String sql){
        SQLiteDatabase database=getWritableDatabase();
        database.execSQL(sql);
    }
    public void insertData(String edtBreakfast, String edtBrmeal, String edtBrtime,String edtLunch,String edtLumeal, String edtLutime, String edtDinner,String edtDimeal, String edtDitime){
        SQLiteDatabase database = getReadableDatabase();
        String sql = "INSERT INTO FOOD VALUES (NULL, ?, ?, ?,?,?,?,?,?,?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1,edtBreakfast);
        statement.bindString(2,edtBrmeal);
        statement.bindString(3,edtBrtime);
        statement.bindString(4,edtLunch);
        statement.bindString(5,edtLumeal);
        statement.bindString(1,edtLutime);
        statement.bindString(2,edtDinner);
        statement.bindString(3,edtDimeal);
        statement.bindString(4,edtDitime);

        statement.executeInsert();

    }
    public Cursor getData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql,null);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
