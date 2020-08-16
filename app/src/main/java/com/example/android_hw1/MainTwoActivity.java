package com.example.android_hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainTwoActivity extends AppCompatActivity {
   private MainActivity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_two);



        final TextView cityText = findViewById(R.id.city_text);
        final TextView weatherText = findViewById(R.id.weather_text);
        Button buttonMoscow = findViewById(R.id.button_Moscow);
        Button buttonPerm = findViewById(R.id.button_Perm);
        Button buttonPetersburg = findViewById(R.id.button_StPetersburg);
        Button buttonOmsk = findViewById(R.id.button_Omsk);
        CheckBox checkBoxWindForce = findViewById(R.id.windForce);


        buttonMoscow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Место под код для обработки нажатия кнопки, для передачи информации на первый экран
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        buttonPerm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Место под код для обработки нажатия кнопки, для передачи информации на первый экран
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        buttonPetersburg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Место под код для обработки нажатия кнопки, для передачи информации на первый экран
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        buttonOmsk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Место под код для обработки нажатия кнопки, для передачи информации на первый экран
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }
}
