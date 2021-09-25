package com.example.foodcoach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Rate extends AppCompatActivity {
    Button _btnFeedBackAdd, _btnFeedbackEdit, _btnFeedbackDlt;
    EditText _TxtFeedbackID, _textFeedbackName ,_TextFeedbackReview;
    SQLiteOpenHelper openHelper;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);

        _btnFeedBackAdd=(Button) findViewById(R.id.btnFeedBackAdd);
        _btnFeedbackEdit=(Button) findViewById(R.id.btnFeedbackEdit);
        _btnFeedbackDlt=(Button) findViewById(R.id.btnFeedbackDlt);
        _TxtFeedbackID=(EditText) findViewById(R.id.TxtFeedbackID);
        _textFeedbackName=(EditText) findViewById(R.id.textFeedbackName);
        _TextFeedbackReview=(EditText) findViewById(R.id.TextFeedbackReview);
        openHelper=new SQLiteHelper(this);
        _btnFeedBackAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name =_textFeedbackName.getText().toString();
                String Review= _TextFeedbackReview.getText().toString();
                sqLiteDatabase=openHelper.getWritableDatabase();
                insertData(name,Review);
                Toast.makeText(getApplicationContext(),"Inserted Successfully",Toast.LENGTH_LONG).show();
            }
        });

        _btnFeedbackEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name =_textFeedbackName.getText().toString();
                String Review= _TextFeedbackReview.getText().toString();
                sqLiteDatabase=openHelper.getWritableDatabase();
                updateData(name,Review);
                Toast.makeText(getApplicationContext(),"Updated Successfully",Toast.LENGTH_LONG).show();
            }
        });

        _btnFeedbackDlt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqLiteDatabase=openHelper.getWritableDatabase();
                String id=_TxtFeedbackID.getText().toString();
                deleteData(id);
                Toast.makeText(getApplicationContext(), "Delete Successfully",Toast.LENGTH_LONG).show();
            }
        });

    }

    public void insertData (String name,String Review){
        ContentValues contentValues= new ContentValues();
        contentValues.put(SQLiteHelper.COLS_2, name);
        contentValues.put(SQLiteHelper.COLS_3, Review);
        long ID = sqLiteDatabase.insert(SQLiteHelper.TABLE_Name, null,contentValues);
    }

    public boolean deleteData(String id){
        return sqLiteDatabase.delete(SQLiteHelper.TABLE_Name,SQLiteHelper.COLS_1 + "=?" , new String[]{id})>0;
    }

    public boolean updateData(String name,String Review){
        ContentValues contentValues= new ContentValues();
        contentValues.put(SQLiteHelper.COLS_2, name);
        contentValues.put(SQLiteHelper.COLS_3, Review);
        String id=_TxtFeedbackID.getText().toString();
        return sqLiteDatabase.update(SQLiteHelper.TABLE_Name,contentValues,SQLiteHelper.COLS_1+"+?",new String[]{id})>0;
    }
}