package com.weatherapp.gnanaraj.weatherapplication.MainActivity.LatLngAdapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.weatherapp.gnanaraj.weatherapplication.Base.BaseViewHolder;
import com.weatherapp.gnanaraj.weatherapplication.BuildConfig;
import com.weatherapp.gnanaraj.weatherapplication.Services.CityGroupModel.CityGroupModel;
import com.weatherapp.gnanaraj.weatherapplication.Services.ForeCastModel.ForeCastModel;
import com.weatherapp.gnanaraj.weatherapplication.Services.LatLngModel.LatLngModel;
import com.weatherapp.gnanaraj.weatherapplication.Utility.Constants;
import com.weatherapp.gnanaraj.weatherapplication.databinding.ListItemLatLngBinding;
import com.weatherapp.gnanaraj.weatherapplication.databinding.ListItemWeatherBinding;

import java.util.HashMap;

public class LatLngWeatherAdapter extends RecyclerView.Adapter<BaseViewHolder>  {

    LatLngModel latLngModel;
    WeatherClickListner mweatherClickListner;
    HashMap<String,String> options;
    private String temp_unit;
    public LatLngWeatherAdapter(LatLngModel latLngModel) {
        this.latLngModel =latLngModel;
        options=new HashMap<>();
    }

    public void setTemp_unit(String temp_unit){
        this.temp_unit=temp_unit;
    }

    public void setWeatherClickListner(WeatherClickListner weatherClickListner) {
        this.mweatherClickListner=weatherClickListner;
    }
    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemLatLngBinding listItemRateChartDetailsBinding=ListItemLatLngBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new weather_viewholder(listItemRateChartDetailsBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }



    @Override
    public int getItemCount() {
         return latLngModel!=null && latLngModel.getWeather().size()>0?latLngModel.getWeather().size():0;
    }

    public void addItems(LatLngModel latLngModel) {
        this.latLngModel=latLngModel;
        notifyDataSetChanged();
    }


    public void ClearItems() {
        if(latLngModel!=null && latLngModel.getWeather().size()>0)
        latLngModel.getWeather().clear();
        notifyDataSetChanged();
    }



    public  class weather_viewholder extends BaseViewHolder implements LatLagWeatherViewModel.WeatherClickListner
    {
        ListItemLatLngBinding listItemWeatherBinding;

        LatLagWeatherViewModel weatherViewModel;

        public weather_viewholder(ListItemLatLngBinding listItemLatLngBinding) {
            super(listItemLatLngBinding.getRoot());
            this.listItemWeatherBinding=listItemLatLngBinding;
        }

        @Override
        public void onBind(int position) {
            weatherViewModel=new LatLagWeatherViewModel(latLngModel,position,this,temp_unit);
            listItemWeatherBinding.setWeatherViewModel(weatherViewModel);
            listItemWeatherBinding.executePendingBindings();

        }

        @Override
        public void onItemClick(long ratechartVersions) {
            mweatherClickListner.onItemClick(ratechartVersions);
        }
    }
    public  interface WeatherClickListner{
        void onItemClick(long ratechartVersions);
    }
}
