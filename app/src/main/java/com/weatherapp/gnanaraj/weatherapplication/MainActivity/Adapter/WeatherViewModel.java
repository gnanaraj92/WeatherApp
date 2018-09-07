package com.weatherapp.gnanaraj.weatherapplication.MainActivity.Adapter;

import android.databinding.ObservableField;
import android.text.Html;

import com.weatherapp.gnanaraj.weatherapplication.Services.CityGroupModel.List;
import com.weatherapp.gnanaraj.weatherapplication.Services.ForeCastModel.ForeCastModel;
import com.weatherapp.gnanaraj.weatherapplication.Utility.CommonUtils;
import com.weatherapp.gnanaraj.weatherapplication.Utility.Constants;

public class WeatherViewModel {
    public ObservableField<String> Sno;
    public ObservableField<String> list_name;
    public ObservableField<String> list_icon;
    public ObservableField<String> weather_desc;
    public ObservableField<String> weather_deg;
    public ObservableField<String> weather_humid;
    public ObservableField<String> weather_wind;
    public ObservableField<String> weather_pressure;
    public ObservableField<String> day_one_forecast;
    public ObservableField<String> day_two_forecast;
    public ObservableField<String> day_three_forecast;
    private String temp_unit;
    private WeatherClickListner weatherClickListner;
    private List list;
    private java.util.List<com.weatherapp.gnanaraj.weatherapplication.Services.ForeCastModel.List> forecast_list;
    public WeatherViewModel(List list, java.util.List<com.weatherapp.gnanaraj.weatherapplication.Services.ForeCastModel.List> forecast_list, int position, WeatherClickListner weatherClickListner,String temp_unit) {
       this.list=list;
       this.temp_unit=temp_unit;
       this.forecast_list=forecast_list;
        position+=1;
        Sno=new ObservableField<>(""+position);
        list_name=new ObservableField<>(list.getName());
        weather_desc=new ObservableField<>(list.getWeather().get(0).getDescription());
        weather_deg=new ObservableField<>(""+list.getMain().getTemp()+" "+Html.fromHtml(temp_unit.equalsIgnoreCase(Constants.STR_UNIT_METRIC)?"&#8451;":"&#8457;\n"));
        weather_humid=new ObservableField<>("Humidity:"+list.getMain().getHumidity()+" % ");
        weather_pressure=new ObservableField<>("Pressure: "+list.getMain().getPressure()+" hpa ");
        weather_wind=new ObservableField<>("Wind: "+list.getWind().getSpeed()+" m/s ");
        list_icon=new ObservableField<>(Constants.STR_CONSTANT_ICON_URL+list.getWeather().get(0).getIcon()+Constants.STR_PNG);
        this.weatherClickListner=weatherClickListner;
        if(forecast_list!=null&&forecast_list.size()>0) {
            day_one_forecast = new ObservableField<>(CommonUtils.getCurrentDate(forecast_list.get(0).getDt())+"-"+forecast_list.get(0).getMain().getTemp()+" "+Html.fromHtml(temp_unit.equalsIgnoreCase(Constants.STR_UNIT_METRIC)?"&#8451;":"&#8457;\n"));
            day_two_forecast = new ObservableField<>(CommonUtils.getCurrentDate(forecast_list.get(8).getDt())+"-"+forecast_list.get(8).getMain().getTemp()+" "+Html.fromHtml(temp_unit.equalsIgnoreCase(Constants.STR_UNIT_METRIC)?"&#8451;":"&#8457;\n"));
            day_three_forecast = new ObservableField<>(CommonUtils.getCurrentDate(forecast_list.get(15).getDt())+"-"+forecast_list.get(15).getMain().getTemp()+" "+Html.fromHtml(temp_unit.equalsIgnoreCase(Constants.STR_UNIT_METRIC)?"&#8451;":"&#8457;\n"));
        }

    }

    public void onItemClick() {
        weatherClickListner.onItemClick(list.getId());
    }

    public  interface WeatherClickListner{
        void onItemClick(long ratechartVersions);
    }

}
