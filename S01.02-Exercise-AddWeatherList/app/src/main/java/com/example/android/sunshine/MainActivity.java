/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.sunshine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // DONE (1) Create a field to store the weather display TextView
    private TextView mWeatherTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);

        // DONE (2) Use findViewById to get a reference to the weather display TextView
        mWeatherTextView = (TextView) findViewById(R.id.tv_weather_data);

        // DONE (3) Create an array of Strings that contain fake weather data
        String[] fakeWeatherData = {
                "Tue, 7th of November, 2017 - Sunny - 12°C / 20°C",
                "Wed, 8th of November, 2017 - Cloudy - 10°C / 14°C",
                "Thu, 9th of November, 2017 - Rainy - 8°C / 12°C",
                "Fri, 10th of November, 2017 - Snowy - 0°C / 2°C",
                "Sat, 11th of November, 2017 - Foggy - 4°C / 8°C",
                "Sun, 12th of November, 2017 - Sunny - 18°C / 27°C",
                "Mon, 13th of November, 2017 - Stormy - 14°C / 21°C",
                "Tue, 14th of November, 2017 - Rainy - 12°C / 20°C"
        };

        // DONE (4) Append each String from the fake weather data array to the TextView
        for(String fakeWeatherEntry : fakeWeatherData) {
            mWeatherTextView.append(fakeWeatherEntry + "\n\n");
        }
    }
}