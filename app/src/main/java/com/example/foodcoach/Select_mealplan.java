package com.example.foodcoach;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Select_mealplan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_mealplan);


        Button button1 = (Button) findViewById(R.id.btn_addmealplan);
        Button button2 = (Button) findViewById(R.id.btn_mymealplan);
        ImageButton profilebutton = (ImageButton) findViewById(R.id.ibtn_profile);
        button1.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                openSelect_gender();
            }

            private void openSelect_gender() {
                Intent intent1=new Intent(Select_mealplan.this, Select_gender.class);
                startActivity(intent1);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSelect_gender();
            }

            private void openSelect_gender() {
                Intent intent2=new Intent(Select_mealplan.this, Meal_plan.class);
                startActivity(intent2);
            }
        });
        profilebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profileintent=new Intent(Select_mealplan.this, Profile_page.class);
                startActivity(profileintent);
            }
        });


    }
}