package com.example.android_hw1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


    public class WeatherActivity extends AppCompatActivity implements Constants {

        @Override
        protected void onCreate(final Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.fragment_weather);
        }
    }
