package com.example.android_hw1;

import java.io.Serializable;

public class Parcel implements Serializable {


    //    int city;
//    int weather;
    int weatherIndex;
    String cityName;
    public int getWeatherIndex() {
        return weatherIndex;
    }

    public String getCityName() {
        return cityName;
    }



    public Parcel(int weatherIndex, String cityName) {
    this.weatherIndex = weatherIndex;
    this.cityName = cityName;
    }
}
