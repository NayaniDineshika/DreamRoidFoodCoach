package com.example.foodcoach;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteHelper extends SQLiteOpenHelper {
    public static final String DATABASE_Name="foodCoachDB";
    public static final String TABLE_Name="feedbackt";

    //COLS
    public static final String COLS_1="ID";
    public static final String COLS_2="name";
    public static final String COLS_3="feedback";

    public SQLiteHelper(@Nullable Context context) {
        super(context, DATABASE_Name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " +TABLE_Name+"(ID INTEGER PRIMARY KEY AUTOINCREMENT , NAME TEXT ,feedback TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_Name);
        onCreate(sqLiteDatabase);
    }
}
