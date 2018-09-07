package com.weatherapp.gnanaraj.weatherapplication.MainActivity;

import com.weatherapp.gnanaraj.weatherapplication.Services.CityGroupModel.CityGroupModel;
import com.weatherapp.gnanaraj.weatherapplication.Services.CityGroupModel.List;
import com.weatherapp.gnanaraj.weatherapplication.Services.ForeCastModel.ForeCastModel;
import com.weatherapp.gnanaraj.weatherapplication.Services.LatLngModel.LatLngModel;

public interface MainActivityNavigator {

    void LoadCities(CityGroupModel cityGroupModel);

    void LoadForeCastModel(ForeCastModel foreCastModel);

    void onError(Throwable throwable);

    void setfahrenheit();

    void setCelsius();

    void LoadLatLng(LatLngModel body);
}
