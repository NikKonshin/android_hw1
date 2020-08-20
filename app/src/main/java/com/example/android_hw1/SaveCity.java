package com.example.android_hw1;

public class SaveCity {

    private static SaveCity INSTANCE = null;
    private int city;

    private SaveCity() {
        city = R.string.button_moscow;
    }

    public void saveCity(int save) {
        city = save;
    }

    public int getCity() {
        return city;
    }

    public static SaveCity getInstanceCity() {
        if (INSTANCE == null) {
            synchronized (SaveWeather.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SaveCity();
                }
            }
        }
        return INSTANCE;
    }
}
