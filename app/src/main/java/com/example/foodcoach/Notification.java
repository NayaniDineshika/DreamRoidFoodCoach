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
    private Button button10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        button10 = (Button) findViewById(R.id.button10);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFeedback();
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
    public void openFeedback(){
        Intent intent= new Intent(this, Feedback.class);
        startActivity(intent);
    }


    public void click(View view) {
        int radioButtonID =rg.getCheckedRadioButtonId();
        rb=(RadioButton) findViewById(radioButtonID);

        Toast.makeText(getBaseContext(),rb.getText(),Toast.LENGTH_LONG).show();
    }
}