package com.example.foodcoach;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class Feedback extends AppCompatActivity {

    Button btnRate;
    RatingBar ratingBar;
    float myRating=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        btnRate = findViewById(R.id.btnRate);
        ratingBar = findViewById(R.id.ratingBar);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
               int rating =(int) v;
               String message =null;

                myRating= ratingBar.getRating();

                switch (rating){
                    case 1:
                    message= "Sorry to hear That! ";
                    break;

                    case 2:
                        message= "You always accept suggestions! ";
                        break;

                    case 3:
                        message= "Good enough! ";
                        break;

                    case 4:
                        message= "Great! ";
                        break;

                    case 5:
                        message= "Awesome!  ";
                        break;
                }

                Toast.makeText(Feedback.this, "Your Rating is "+message, Toast.LENGTH_SHORT).show();
            }
        });

        btnRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Feedback.this, "Your Rating is "+String.valueOf(myRating), Toast.LENGTH_SHORT).show();
            }
        });
        

    }
}