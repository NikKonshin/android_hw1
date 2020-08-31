package com.example.android_hw1;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


    public class WeatherActivity extends AppCompatActivity implements Constants {

        @Override
        protected void onCreate(final Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_weather);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            finish();
            return;
        }
        if (savedInstanceState == null){
            WeatherFragment weatherFragment = new WeatherFragment();
            weatherFragment.setArguments(getIntent().getExtras());

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,weatherFragment).commit();
        }
        }
    }
