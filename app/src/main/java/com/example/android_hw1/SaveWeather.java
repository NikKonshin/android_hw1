package com.example.android_hw1;

public class SaveWeather {
    private static SaveWeather INSTANCE = null;
    private int weather;

    private SaveWeather(){
        weather = R.string.weather_moscow;
    }

    public void saveWeather (int save){
        weather = save;
    }
    public int getWeather(){
        return weather;
    }


    public static SaveWeather getInstanceWeather(){
        if(INSTANCE == null){
            synchronized (SaveWeather.class){
                if (INSTANCE== null){
                    INSTANCE = new SaveWeather();
                }
            }
        }
        return INSTANCE;
    }
}

