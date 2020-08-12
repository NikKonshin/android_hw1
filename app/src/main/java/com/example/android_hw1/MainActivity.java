package com.example.android_hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView cityText = findViewById(R.id.city_text);
        final TextView weatherText = findViewById(R.id.weather_text);
        Button buttonMoscow = findViewById(R.id.button_Moscow);
        Button buttonPerm = findViewById(R.id.button_Perm);
        Button buttonPetersburg = findViewById(R.id.button_StPetersburg);
        Button buttonOmsk = findViewById(R.id.button_Omsk);


        buttonMoscow.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                cityText.setText(R.string.city_moscow);
                weatherText.setText(R.string.weather_moscow);
            }
        });

        buttonPerm.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                cityText.setText(R.string.button_perm);
                weatherText.setText(R.string.weather_perm);
            }
        });

        buttonPetersburg.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                cityText.setText(R.string.button_petersburg);
                weatherText.setText(R.string.weather_petersburg);
            }
        });

        buttonOmsk.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                cityText.setText(R.string.button_omsk);
                weatherText.setText(R.string.weather_omsk);
            }
        });




    }


}
