package com.example.android_hw1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainSettingsActivity extends AppCompatActivity implements Constants {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_settings);

        String instanceState;
        if (savedInstanceState == null){
            instanceState = "Первый запуск!";
        } else {
            instanceState = "Повторный запуск";
        }
        Toast.makeText(getApplicationContext(),instanceState + " - onCreate", Toast.LENGTH_SHORT).show();
        Log.d("LogActivity",instanceState + " - onCreate Activity #3");

        RadioButton darkTheme = findViewById(R.id.radio_button_dark_theme);
        Button buttonSave = findViewById(R.id.button_save);


        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

        darkTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Место под код
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext()," onStart", Toast.LENGTH_SHORT).show();
        Log.d("LogActivity", "onStart Activity #3");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Toast.makeText(getApplicationContext()," onRestoreInstanceState", Toast.LENGTH_SHORT).show();
        Log.d("LogActivity", "onRestoreInstanceState Activity #3");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext()," onResume", Toast.LENGTH_SHORT).show();
        Log.d("LogActivity", "onResume Activity #3");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext()," onPause", Toast.LENGTH_SHORT).show();
        Log.d("LogActivity", "onPause Activity #3");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Toast.makeText(getApplicationContext()," onSaveInstanceState", Toast.LENGTH_SHORT).show();
        Log.d("LogActivity", "onSaveInstanceState Activity #3");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext()," onStop", Toast.LENGTH_SHORT).show();
        Log.d("LogActivity", "onStop Activity #3");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext()," onRestart", Toast.LENGTH_SHORT).show();
        Log.d("LogActivity", "onRestart Activity #3");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext()," onDestroy", Toast.LENGTH_SHORT).show();
        Log.d("LogActivity", "onDestroy Activity #3");
    }

}
