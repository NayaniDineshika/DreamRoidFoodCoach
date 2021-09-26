package com.example.foodcoach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_home);

        Button buttonVegitarian = findViewById(R.id.Vegetariant);
        buttonVegitarian.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startVeg();
            }
        });
    }
    private void startVeg() {
        Intent intent = new Intent(MyHome.this, MainActivity2.class);
        startActivity(intent);
   }
}