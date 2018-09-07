package com.weatherapp.gnanaraj.weatherapplication.MainActivity.Adapter;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.weatherapp.gnanaraj.weatherapplication.Base.BaseViewHolder;
import com.weatherapp.gnanaraj.weatherapplication.BuildConfig;
import com.weatherapp.gnanaraj.weatherapplication.R;
import com.weatherapp.gnanaraj.weatherapplication.Services.CityGroupModel.CityGroupModel;
import com.weatherapp.gnanaraj.weatherapplication.Services.ForeCastModel.ForeCastModel;
import com.weatherapp.gnanaraj.weatherapplication.Services.Network.RemoteServices;
import com.weatherapp.gnanaraj.weatherapplication.Utility.Constants;
import com.weatherapp.gnanaraj.weatherapplication.databinding.ListItemWeatherBinding;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherAdapter extends RecyclerView.Adapter<BaseViewHolder>  {

    CityGroupModel mcityGroupModels;
    ForeCastModel foreCastModel;
    WeatherClickListner mweatherClickListner;
    HashMap<String,String> options;
    private String temp_unit;
    public WeatherAdapter(CityGroupModel cityGroupModels) {
        mcityGroupModels =cityGroupModels;
        options=new HashMap<>();
        foreCastModel=new ForeCastModel();
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
        ListItemWeatherBinding listItemRateChartDetailsBinding=ListItemWeatherBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new weather_viewholder(listItemRateChartDetailsBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }



    @Override
    public int getItemCount() {
         return mcityGroupModels!=null && mcityGroupModels.getList().size()>0?mcityGroupModels.getList().size():0;
    }

    public void addItems(CityGroupModel cityGroupModel) {
        mcityGroupModels.setList(cityGroupModel.getList());
        notifyDataSetChanged();
    }

    public void addForeCastdata(ForeCastModel foreCastModel) {
        this.foreCastModel.setList(foreCastModel.getList());
        notifyDataSetChanged();
    }

    public void ClearItems() {
        if(mcityGroupModels!=null && mcityGroupModels.getList().size()>0)
        mcityGroupModels.getList().clear();
        notifyDataSetChanged();
    }



    public  class weather_viewholder extends BaseViewHolder implements WeatherViewModel.WeatherClickListner
    {
        ListItemWeatherBinding listItemWeatherBinding;

        WeatherViewModel weatherViewModel;

        public weather_viewholder(ListItemWeatherBinding listItemWeatherBinding) {
            super(listItemWeatherBinding.getRoot());
            this.listItemWeatherBinding=listItemWeatherBinding;
        }

        @Override
        public void onBind(int position) {
            options.put(Constants.STR_URL_PARAM_WEATHER_ID,""+mcityGroupModels.getList().get(position).getId());
            options.put(Constants.STR_APP_ID, BuildConfig.API_KEY);
            weatherViewModel=new WeatherViewModel(mcityGroupModels.getList().get(position),foreCastModel.getList(),position,this,temp_unit);
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
