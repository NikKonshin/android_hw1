package com.example.android_hw1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String instanceState;
        if (savedInstanceState == null){
            instanceState = "Первый запуск!";
        } else {
            instanceState = "Повторный запуск";
        }
        Toast.makeText(getApplicationContext(),instanceState + " - onCreate", Toast.LENGTH_SHORT).show();
        Log.d("LogActivity",instanceState + " - onCreate Activity #1");

    final TextView cityText = findViewById(R.id.city_text);
    final TextView weatherText = findViewById(R.id.weather_text);
    Button buttonChooseCity = findViewById(R.id.button_choose_city);
    Button buttonSettings = findViewById(R.id.button_settings);

        final SaveCity saveCity = SaveCity.getInstanceCity();
        final SaveWeather saveWeather = SaveWeather.getInstanceWeather();
        cityText.setText(saveCity.getCity());
        weatherText.setText(saveWeather.getWeather());


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

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext()," onStart", Toast.LENGTH_SHORT).show();
        Log.d("LogActivity", "onStart Activity #1");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Toast.makeText(getApplicationContext()," onRestoreInstanceState", Toast.LENGTH_SHORT).show();
        Log.d("LogActivity", "onRestoreInstanceState Activity #1");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext()," onResume", Toast.LENGTH_SHORT).show();
        Log.d("LogActivity", "onResume Activity #1");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext()," onPause", Toast.LENGTH_SHORT).show();
        Log.d("LogActivity", "onPause Activity #1");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Toast.makeText(getApplicationContext()," onSaveInstanceState", Toast.LENGTH_SHORT).show();
        Log.d("LogActivity", "onSaveInstanceState Activity #1");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext()," onStop", Toast.LENGTH_SHORT).show();
        Log.d("LogActivity", "onStop Activity #1");

}

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext()," onRestart", Toast.LENGTH_SHORT).show();
        Log.d("LogActivity", "onRestart Activity #1");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext()," onDestroy", Toast.LENGTH_SHORT).show();
        Log.d("LogActivity", "onDestroy Activity #1");
    }
}
