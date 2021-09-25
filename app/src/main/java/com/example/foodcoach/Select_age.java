package com.example.foodcoach;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Select_age extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_age);


        Button button1 = (Button) findViewById(R.id.btn_1to5);
        Button button2 = (Button) findViewById(R.id.btn_6to17);
        button1.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                openAdd_meal();
            }

            private void openAdd_meal() {
                Intent intent1=new Intent(Select_age.this, Add_meal.class);
                startActivity(intent1);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAdd_meal();
            }

            private void openAdd_meal() {
                Intent intent2=new Intent(Select_age.this, Add_meal.class);
                startActivity(intent2);
            }
        });


    }
}