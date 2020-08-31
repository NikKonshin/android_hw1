package com.example.android_hw1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CitiesAdapter extends RecyclerView.Adapter<CitiesAdapter.CityViewHolder> {

    //private List<Integer> cities = new ArrayList<>(Collections.singletonList(R.array.citiesArr));
    private String[] cities;
    private OnCityClickListener onCityClickListener;

    public CitiesAdapter(String[] cities) {
        this.cities = cities;
    }


    public String[] getCities() {
        return cities;
    }

    public void setCities(String[] cities){
    this.cities = cities;
    notifyDataSetChanged();
    }


    @NonNull
    @Override
    public CityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CityViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_city,parent,false));
    }

    public void setOnCityClickListener(OnCityClickListener onCityClickListener) {
        this.onCityClickListener = onCityClickListener;
    }

    @Override
    public void onBindViewHolder(@NonNull CityViewHolder holder, int position) {
       holder.bind(cities[position], onCityClickListener);
        //new
       // holder.textView.setText(cities[position]);

    }

    @Override
    public int getItemCount() {
        if (cities == null){
            return 0;
        }
        // new
        return cities.length;
       // return cities.size();
    }

    static class CityViewHolder extends RecyclerView.ViewHolder{
       private final TextView textView;
       private final View chevron;

        public CityViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.cityTextView);
            chevron = itemView.findViewById(R.id.chevron_right);
        }

        void bind(final String city, final OnCityClickListener onCityClickListener){
            textView.setText(city);
            chevron.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onCityClickListener != null) {
                        onCityClickListener.onClicked(city);
                    }
                }
            });
        }
    }


    interface OnCityClickListener{

        void onClicked(String city);
    }
}
