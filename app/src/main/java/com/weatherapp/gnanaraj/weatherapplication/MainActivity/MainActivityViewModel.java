package com.weatherapp.gnanaraj.weatherapplication.MainActivity;

import android.os.RemoteException;

import com.weatherapp.gnanaraj.weatherapplication.Base.BaseViewModel;
import com.weatherapp.gnanaraj.weatherapplication.Repository.UseCase.AddUseCase;
import com.weatherapp.gnanaraj.weatherapplication.Repository.UseCase.DeleteUseCase;
import com.weatherapp.gnanaraj.weatherapplication.Repository.UseCase.GetUseCase;
import com.weatherapp.gnanaraj.weatherapplication.Repository.UseCase.UpdateUseCase;
import com.weatherapp.gnanaraj.weatherapplication.Services.CityGroupModel.CityGroupModel;
import com.weatherapp.gnanaraj.weatherapplication.Services.ForeCastModel.ForeCastModel;
import com.weatherapp.gnanaraj.weatherapplication.Services.LatLngModel.LatLngModel;
import com.weatherapp.gnanaraj.weatherapplication.Services.Network.RemoteServices;
import com.weatherapp.gnanaraj.weatherapplication.rx.SchedulerProvider;

import java.io.IOException;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends BaseViewModel<MainActivityNavigator> {


    public MainActivityViewModel(SchedulerProvider schedulerProvider, AddUseCase addUseCase, GetUseCase getUseCase, DeleteUseCase deleteUseCase, UpdateUseCase updateUseCase) {
        super(schedulerProvider, addUseCase, getUseCase, deleteUseCase, updateUseCase);
    }

    public void LoadRemoteServices(HashMap<String,String> options) throws IOException, RemoteException {
            RemoteServices.getInstance().getGroupCityWeather(options).enqueue(new Callback<CityGroupModel>() {
                @Override
                public void onResponse(Call<CityGroupModel> call, Response<CityGroupModel> response) {
                    if(response.body()!=null){
                        getNavigator().LoadCities(response.body());
                    }
                }

                @Override
                public void onFailure(Call<CityGroupModel> call, Throwable t) {
                    getNavigator().onError(t);
                }
            });

        }

    public void LoadForCastServices(HashMap<String,String> options) throws IOException, RemoteException {
        RemoteServices.getInstance().getForeCastWeather(options).enqueue(new Callback<ForeCastModel>() {
            @Override
            public void onResponse(Call<ForeCastModel> call, Response<ForeCastModel> response) {
                if(response.body()!=null){
                    getNavigator().LoadForeCastModel(response.body());
                }
            }

            @Override
            public void onFailure(Call<ForeCastModel> call, Throwable t) {
                getNavigator().onError(t);
            }
        });

    }

    public void LoadLatLngModel(HashMap<String,String> options) throws IOException, RemoteException {
        RemoteServices.getInstance().getCityWeatherLatLng(options).enqueue(new Callback<LatLngModel>() {
            @Override
            public void onResponse(Call<LatLngModel> call, Response<LatLngModel> response) {
                getNavigator().LoadLatLng(response.body());
            }

            @Override
            public void onFailure(Call<LatLngModel> call, Throwable t) {
                    getNavigator().onError(t);
            }
        });
    }

}
