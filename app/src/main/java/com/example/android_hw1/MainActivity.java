package com.example.android_hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    final TextView cityText = findViewById(R.id.city_text);
    final TextView weatherText = findViewById(R.id.weather_text);
    Button buttonChooseCity = findViewById(R.id.button_choose_city);
    Button buttonSettings = findViewById(R.id.button_settings);

        buttonSettings.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
//                Временный код
                startActivity(new Intent(getApplicationContext(),MainSettingsActivity.class));
            }
        });

        buttonChooseCity.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
//                Временный код

                startActivity(new Intent(getApplicationContext(),MainTwoActivity.class));
            }
        });


    }



}
