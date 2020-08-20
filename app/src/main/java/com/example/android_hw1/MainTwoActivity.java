package com.example.android_hw1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainTwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_two);
        String instanceState;
        if (savedInstanceState == null){
            instanceState = "Первый запуск!";
        } else {
            instanceState = "Повторный запуск";
        }
        Toast.makeText(getApplicationContext(),instanceState + " - onCreate", Toast.LENGTH_SHORT).show();
        Log.d("LogActivity",instanceState + " - onCreate Activity #2");




        Button buttonMoscow = findViewById(R.id.button_Moscow);
        Button buttonPerm = findViewById(R.id.button_Perm);
        Button buttonPetersburg = findViewById(R.id.button_StPetersburg);
        Button buttonOmsk = findViewById(R.id.button_Omsk);
        CheckBox checkBoxWindForce = findViewById(R.id.windForce);
       final SaveCity saveCity = SaveCity.getInstanceCity();
       final SaveWeather saveWeather = SaveWeather.getInstanceWeather();


        buttonMoscow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Место под код для обработки нажатия кнопки, для передачи информации на первый экран
                saveCity.saveCity(R.string.city_moscow);
                saveWeather.saveWeather(R.string.weather_moscow);

                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        buttonPerm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Место под код для обработки нажатия кнопки, для передачи информации на первый экран
                saveCity.saveCity(R.string.button_perm);
                saveWeather.saveWeather(R.string.weather_perm);
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        buttonPetersburg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Место под код для обработки нажатия кнопки, для передачи информации на первый экран
                saveCity.saveCity(R.string.button_petersburg);
                saveWeather.saveWeather(R.string.weather_petersburg);
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        buttonOmsk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Место под код для обработки нажатия кнопки, для передачи информации на первый экран
                saveCity.saveCity(R.string.button_omsk);
                saveWeather.saveWeather(R.string.weather_omsk);
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext()," onStart", Toast.LENGTH_SHORT).show();
        Log.d("LogActivity", "onStart Activity #2");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Toast.makeText(getApplicationContext()," onRestoreInstanceState", Toast.LENGTH_SHORT).show();
        Log.d("LogActivity", "onRestoreInstanceState Activity #2");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext()," onResume", Toast.LENGTH_SHORT).show();
        Log.d("LogActivity", "onResume Activity #2");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext()," onPause", Toast.LENGTH_SHORT).show();
        Log.d("LogActivity", "onPause Activity #2");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Toast.makeText(getApplicationContext()," onSaveInstanceState", Toast.LENGTH_SHORT).show();
        Log.d("LogActivity", "onSaveInstanceState Activity #2");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext()," onStop", Toast.LENGTH_SHORT).show();
        Log.d("LogActivity", "onStop Activity #2");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext()," onRestart", Toast.LENGTH_SHORT).show();
        Log.d("LogActivity", "onRestart Activity #2");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext()," onDestroy", Toast.LENGTH_SHORT).show();
        Log.d("LogActivity", "onDestroy Activity #2");
    }
}
