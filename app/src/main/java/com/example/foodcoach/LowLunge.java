package com.example.foodcoach;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.Toast;

public class LowLunge extends AppCompatActivity {
    private Chronometer chronometer;
    private boolean running;
    private long pauseOffset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_low_lunge);

        chronometer = findViewById(R.id.chronometer);

    }

    public void startChronometer(View view){
        if(!running){
            chronometer.setBase(SystemClock.elapsedRealtime() -pauseOffset);
            chronometer.start();
            running = true;
        }
    }

    public void pauseChronometer(View view){
        if(running){
            chronometer.stop();
            pauseOffset =SystemClock.elapsedRealtime() - chronometer.getBase();
            running = false;
        }

    }

    public void resetChronometer(View view){
        chronometer.setBase(SystemClock.elapsedRealtime());
        pauseOffset=0;
    }
}