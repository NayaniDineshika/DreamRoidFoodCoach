package com.example.foodcoach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Yoga extends AppCompatActivity {
    private Button btnWarriorPose;
    private Button btnUpwardBow;
    private Button btnHalfPigeon;
    private Button btnLowLunge;
    private Button btneasy_pose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga);

        btnLowLunge = (Button) findViewById(R.id.btnLowLunge);
        btnLowLunge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenLowLunge();
            }
        });

        btnWarriorPose = (Button) findViewById(R.id.btnWarriorPose);
        btnWarriorPose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenWarriorPose();
            }
        });

        btnUpwardBow = (Button) findViewById(R.id.btnUpwardBow);
        btnUpwardBow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenUpwardBow();
            }
        });

        btnHalfPigeon = (Button) findViewById(R.id.btnHalfPigeon);
        btnHalfPigeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenHalfPigeon();
            }
        });

        btneasy_pose = (Button) findViewById(R.id.btneasy_pose);
        btneasy_pose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Openeasy_pose();
            }
        });
    }

    public void OpenLowLunge(){
        Intent intent = new Intent(this,LowLunge.class);
        startActivity(intent);
    }

    public void OpenWarriorPose(){
        Intent intent = new Intent(this,WarriorPose.class);
        startActivity(intent);
    }

    public void OpenUpwardBow(){
        Intent intent = new Intent(this,upward_bow.class);
        startActivity(intent);
    }

    public void OpenHalfPigeon(){
        Intent intent = new Intent(this,HalfPigeon.class);
        startActivity(intent);
    }

    public void Openeasy_pose(){
        Intent intent = new Intent(this,EasyPose.class);
        startActivity(intent);
    }
}