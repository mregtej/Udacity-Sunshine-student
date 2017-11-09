package com.example.android.sunshine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private TextView mWeatherDisplayTextView;

    private static final String FORECAST_SHARE_HASHTAG = " #SunshineApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mWeatherDisplayTextView = (TextView) findViewById(R.id.tv_weather_display);

        // DONE (2) Display the weather forecast that was passed from MainActivity
        Intent intent = this.getIntent();
        if(intent.hasExtra(Intent.EXTRA_TEXT)) {
            String weather = intent.getStringExtra(Intent.EXTRA_TEXT);
            mWeatherDisplayTextView.setText(weather);
        }
    }
}