package com.example.android_hw1;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class WeatherFragment extends Fragment {
    public static final String PARCEL = "parcel";
    Parcel parcel;





    public static WeatherFragment create(Parcel parcel){
        WeatherFragment wf = new WeatherFragment();

        Bundle args = new Bundle();
        args.putSerializable(PARCEL,parcel);
        wf.setArguments(args);
        return wf;

    }

    public Parcel getParcel(){
        Parcel parcel = (Parcel) getArguments().getSerializable(PARCEL);
        return parcel;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_weather,container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView cityText = view.findViewById(R.id.city_text2);
        TextView weatherText = view.findViewById(R.id.weather_text2);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview_weather);
        String [] forecast = {"Место под код","Место под код","Место под код"};
        CitiesAdapter citiesAdapter = new CitiesAdapter(forecast);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(citiesAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        citiesAdapter.setCities(forecast);

        TypedArray weather = getResources().obtainTypedArray(R.array.weatherArr);
        Parcel parcel = getParcel();

        cityText.setText(parcel.getCityName());
        cityText.setTextSize(30);
        weatherText.setText(weatherArray(parcel.getWeatherIndex()));
        weatherText.setTextSize(30);

    }

    private String weatherArray(int index){
        String[] weather = getResources().getStringArray(R.array.weatherArr);
        String currentWeather = "";
        for (int i = 0; i <weather.length ; i++) {
            if(i == index){
                currentWeather = weather[i];
            }
        }
        return currentWeather;
    }
}
