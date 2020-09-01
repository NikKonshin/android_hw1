package com.example.android_hw1;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import static com.example.android_hw1.WeatherFragment.PARCEL;

public class CitiesFragment extends Fragment {
    boolean isLandscape;
    Parcel parcel;
    public static final String CURRENT_CITY = "city";
    public static final int FIRST_ELEMENT = 0;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initList(view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isLandscape = getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE;

        if(savedInstanceState != null){

            if(savedInstanceState.getSerializable(CURRENT_CITY) instanceof Parcel) {

                parcel = (Parcel) savedInstanceState.getSerializable(CURRENT_CITY);

            } else {
                parcel = new Parcel(FIRST_ELEMENT, getResources().getStringArray(R.array.citiesArr)[FIRST_ELEMENT]);
            }
        } else {
            parcel = new Parcel(FIRST_ELEMENT, getResources().getStringArray(R.array.citiesArr)[FIRST_ELEMENT]);
        }

        if(isLandscape){
            showWeather(parcel);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putSerializable(CURRENT_CITY,parcel);
        super.onSaveInstanceState(outState);
    }

    private void initList(View view) {
        LinearLayout layoutView = (LinearLayout) view;
        String[] cities = getResources().getStringArray(R.array.citiesArr);

        for (int i = 0; i <cities.length ; i++) {
            String city = cities[i];
            TextView textView = new TextView(getContext());
            textView.setText(city);
            textView.setTextSize(25);
            layoutView.addView(textView);
            final int fi = i;


            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    parcel = new Parcel(fi, getResources().getStringArray(R.array.citiesArr)[fi]);
                    showWeather(parcel);

                }
            });
        }
    }
    private void showWeather(Parcel parcel){
        if(isLandscape){
            WeatherFragment weatherFragment = (WeatherFragment) getFragmentManager().findFragmentById(R.id.weather);
            if(weatherFragment == null|| weatherFragment.getParcel().getWeatherIndex() != parcel.getWeatherIndex()){
                weatherFragment = WeatherFragment.create(parcel);

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.weather, weatherFragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }
        }else {
            Intent intent = new Intent(getContext(),WeatherActivity.class);
            intent.putExtra(PARCEL, parcel);
            startActivity(intent);
        }
    }
}

