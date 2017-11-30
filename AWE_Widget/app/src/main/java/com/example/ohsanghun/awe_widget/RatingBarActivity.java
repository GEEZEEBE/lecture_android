package com.example.ohsanghun.awe_widget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RatingBar;
import android.widget.Toast;

public class RatingBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_bar);

        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        int numStars = ratingBar.getNumStars();
        ratingBar.setRating((float) 4.2);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                String text = rating + ", " + String.valueOf(ratingBar.getRating());

                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
