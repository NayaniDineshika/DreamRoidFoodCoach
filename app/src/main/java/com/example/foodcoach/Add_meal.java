package com.example.foodcoach;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Add_meal extends AppCompatActivity {

    EditText edtBrmeal,edtBrtime,edtLumeal,edtLutime,edtDimeal,edtDitime;
    Button btn_addmeal;

    public static SQLiteHelper sqLiteHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meal);

        init();

        sqLiteHelper=new SQLiteHelper(this,"ADDMEALDB.sqlite",null,1);

        sqLiteHelper.queryData("CREATE TABLE IF NOT EXISTS FOOD(Id INTEGER PRIMARY KEY AUTOINCREMENT,breakfast VARCHAR, brmeal VARCHAR, brtime VARCHAR, lunch VARCHAR, lumeal VARCHAR, lutime VARCHAR, dinner VARCHAR, dimeal VARCHAR, ditime VARCHAR)");
    }
    private  void init(){

        edtBrmeal=(EditText) findViewById(R.id.edtBrmeal);
        edtBrtime=(EditText) findViewById(R.id.edtBrtime);

        edtLumeal=(EditText) findViewById(R.id.edtLumeal);
        edtLutime=(EditText) findViewById(R.id.edtLutime);

        edtDimeal=(EditText) findViewById(R.id.edtDimeal);
        edtDitime=(EditText) findViewById(R.id.edtDitime);
        btn_addmeal=(Button) findViewById(R.id.btn_addmeal);
    }


}