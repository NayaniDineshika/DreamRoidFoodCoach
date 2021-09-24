package com.example.foodcoach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class Notification extends AppCompatActivity {

    RadioGroup rg;
    RadioButton rb;
    Switch aSwitch;
    private Button btnRate;
    private Button btnAbout;
    private Button btnPolicy2;
    private Button btnRatings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        btnRate = (Button) findViewById(R.id.btnRate);
        btnRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFeedback();
            }
        });

        btnPolicy2 = (Button) findViewById(R.id.btnPolicy2);
        btnPolicy2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPolicy();
            }
        });

        btnAbout = (Button) findViewById(R.id.btnAbout);
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAboutUs();
            }
        });

        btnRatings = (Button) findViewById(R.id.btnRatings);
        btnRatings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               openRate();
            }
        });

        rg = (RadioGroup) findViewById(R.id.Rgroup);

        aSwitch =(Switch) findViewById(R.id.switch1);

       aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
               if (isChecked==true){
                   Toast.makeText(getBaseContext(),"Notification ON",Toast.LENGTH_LONG).show();
               }
               else{
                   Toast.makeText(getBaseContext(),"Notification OFF",Toast.LENGTH_LONG).show();
               }
           }
       });

    }

    public void openRate(){
        Intent intent= new Intent(this, Feedback.class);
        startActivity(intent);
    }
    public void openFeedback(){
        Intent intent= new Intent(this, Rate.class);
        startActivity(intent);
    }

    public void openAboutUs(){
        Intent intent= new Intent(this, AboutUs.class);
        startActivity(intent);
    }

    public void openPolicy(){
        Intent intent= new Intent(this, PrivacyPolicy.class);
        startActivity(intent);
    }


    public void click(View view) {
        int radioButtonID =rg.getCheckedRadioButtonId();
        rb=(RadioButton) findViewById(radioButtonID);

        Toast.makeText(getBaseContext(),rb.getText(),Toast.LENGTH_LONG).show();
    }
}