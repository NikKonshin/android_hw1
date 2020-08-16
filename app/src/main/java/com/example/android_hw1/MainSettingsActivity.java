package com.example.android_hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainSettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_settings);
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
}
