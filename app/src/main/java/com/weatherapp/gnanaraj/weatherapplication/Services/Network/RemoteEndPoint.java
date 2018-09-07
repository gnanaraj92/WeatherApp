package com.weatherapp.gnanaraj.weatherapplication.Services.Network;

import com.weatherapp.gnanaraj.weatherapplication.Services.CityGroupModel.CityGroupModel;
import com.weatherapp.gnanaraj.weatherapplication.Services.ForeCastModel.ForeCastModel;
import com.weatherapp.gnanaraj.weatherapplication.Services.LatLngModel.LatLngModel;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface RemoteEndPoint {
    @GET("weather")
    Call<LatLngModel> getCityWeatherLatLng(@QueryMap Map<String,String> options);

    @GET("group")
    Call<CityGroupModel> getGroupCityWeather(@QueryMap Map<String,String> options);


    @GET("forecast")
    Call<ForeCastModel> getForeCastWeather(@QueryMap Map<String,String> options);
}
