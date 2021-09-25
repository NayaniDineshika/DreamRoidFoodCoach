package com.example.foodcoach;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Select_gender extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_gender);

        Button button1 = (Button) findViewById(R.id.btn_male);
        Button button2 = (Button) findViewById(R.id.btn_female);
        button1.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                openSelect_age();
            }

            private void openSelect_age() {
                Intent intent1=new Intent(Select_gender.this, Select_age.class);
                startActivity(intent1);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSelect_age();
            }

            private void openSelect_age() {
                Intent intent2=new Intent(Select_gender.this, Select_age.class);
                startActivity(intent2);
            }
        });

    }
}