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
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.example.android_hw1.WeatherFragment.PARCEL;

public class CitiesFragment extends Fragment {
    boolean isLandscape;
    Parcel parcel;
    public static final String CURRENT_CITY = "city";
    public static final int FIRST_ELEMENT = 0;
    public static final int REQUEST_CODE = 32;
    private String[] cities;

    // новая строчка
//    private final Integer[] cities = {R.string.button_moscow, R.string.button_perm,
//            R.string.button_omsk,R.string.button_petersburg};
    // private final List<Integer> cities = new ArrayList<>(Collections.singletonList(R.array.citiesArr));


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerview_cities2);
        cities = getResources().getStringArray(R.array.citiesArr);
        final CitiesAdapter adapter = new CitiesAdapter(cities);

        if (savedInstanceState == null) {

            for (int i = 0; i < cities.length; i++) {
                String city = cities[i];
                final int fi = i;

                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

                //FragmentTransaction ft = getFragmentManager().beginTransaction();


                recyclerView.setAdapter(adapter);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                adapter.setCities(cities);

                adapter.setOnCityClickListener(new CitiesAdapter.OnCityClickListener() {
                    @Override
                    public void onClicked(String city) {

//                        WeatherFragment weatherFragment = new WeatherFragment();
//                        FragmentTransaction ft = getFragmentManager().beginTransaction();
//                        ft.replace(R.id.frame_layout_container, weatherFragment);
//                        ft.addToBackStack(null);
//                        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
//                        ft.commit();
                        parcel = new Parcel(fi, getResources().getStringArray(R.array.citiesArr)[fi]);
                        showWeather(parcel);
                    }
                });

            }


        }

        // новая строчка
        // initList(view);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isLandscape = getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE;

        if (savedInstanceState != null) {

            if (savedInstanceState.getSerializable(CURRENT_CITY) instanceof Parcel) {

                parcel = (Parcel) savedInstanceState.getSerializable(CURRENT_CITY);

            } else {
                parcel = new Parcel(FIRST_ELEMENT, getResources().getStringArray(R.array.citiesArr)[FIRST_ELEMENT]);
            }
        } else {
            parcel = new Parcel(FIRST_ELEMENT, getResources().getStringArray(R.array.citiesArr)[FIRST_ELEMENT]);
        }

        if (isLandscape) {
            showWeather(parcel);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putSerializable(CURRENT_CITY, parcel);
        super.onSaveInstanceState(outState);
    }

    private void initList(View view) {
////        LinearLayout layoutView = (LinearLayout) view;
//
//
//
//        for (int i = 0; i <cities.length ; i++) {
//            String city = cities[i];
////            TextView textView = new TextView(getContext());
////            textView.setText(city);
////            textView.setTextSize(25);
//
//
//            final int fi = i;
//
//
//            textView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    parcel = new Parcel(fi, getResources().getStringArray(R.array.citiesArr)[fi]);
//                    showWeather(parcel);
//
//                }
//
//            });
//        }

    }

    private void showWeather(Parcel parcel) {
        if (isLandscape) {
            WeatherFragment weatherFragment = (WeatherFragment) getFragmentManager().findFragmentById(R.id.weather);
            if (weatherFragment == null || weatherFragment.getParcel().getWeatherIndex() != parcel.getWeatherIndex()) {
                weatherFragment = WeatherFragment.create(parcel);
                weatherFragment.setTargetFragment(this, REQUEST_CODE);

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.weather, weatherFragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();

            }
        } else {
//            Intent intent = new Intent(getContext(),WeatherActivity.class);
//            intent.putExtra(PARCEL, parcel);
//            startActivityForResult(intent,REQUEST_CODE);
            WeatherFragment weatherFragment = (WeatherFragment) getFragmentManager().findFragmentById(R.id.weather2);
            if (weatherFragment == null || weatherFragment.getParcel().getWeatherIndex() != parcel.getWeatherIndex()) {
                weatherFragment = WeatherFragment.create(parcel);
                weatherFragment.setTargetFragment(this, REQUEST_CODE);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame_layout_container, weatherFragment);
                ft.addToBackStack(null);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }


        }
    }


}

