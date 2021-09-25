package com.example.foodcoach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Fitness extends AppCompatActivity {

    private Button btnYoga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness);

        btnYoga = (Button) findViewById(R.id.btnYoga);
        btnYoga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                OpenYoga();
            }
        });

    }

    public void OpenYoga(){
        Intent intent = new Intent(this,Yoga.class);
        startActivity(intent);
    }
}