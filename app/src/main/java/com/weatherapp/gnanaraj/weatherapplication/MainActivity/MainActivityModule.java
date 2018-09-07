package com.weatherapp.gnanaraj.weatherapplication.MainActivity;


import com.weatherapp.gnanaraj.weatherapplication.MainActivity.Adapter.WeatherAdapter;
import com.weatherapp.gnanaraj.weatherapplication.MainActivity.LatLngAdapter.LatLngWeatherAdapter;
import com.weatherapp.gnanaraj.weatherapplication.Repository.LocalRepository;
import com.weatherapp.gnanaraj.weatherapplication.Repository.RemoteRepository;
import com.weatherapp.gnanaraj.weatherapplication.Repository.UseCase.AddUseCase;
import com.weatherapp.gnanaraj.weatherapplication.Repository.UseCase.DeleteUseCase;
import com.weatherapp.gnanaraj.weatherapplication.Repository.UseCase.GetUseCase;
import com.weatherapp.gnanaraj.weatherapplication.Repository.UseCase.SyncUseCase;
import com.weatherapp.gnanaraj.weatherapplication.Repository.UseCase.UpdateUseCase;
import com.weatherapp.gnanaraj.weatherapplication.Services.CityGroupModel.CityGroupModel;
import com.weatherapp.gnanaraj.weatherapplication.Services.CityGroupModel.List;
import com.weatherapp.gnanaraj.weatherapplication.Services.LatLngModel.LatLngModel;
import com.weatherapp.gnanaraj.weatherapplication.rx.SchedulerProvider;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {
    @Provides
    MainActivityViewModel provideProducerDetailsViewModel(SchedulerProvider schedulerProvider,AddUseCase addUseCase, GetUseCase getUseCase, DeleteUseCase deleteUseCase, UpdateUseCase updateUseCase) {
        return new MainActivityViewModel(schedulerProvider, addUseCase, getUseCase, deleteUseCase, updateUseCase);
    }

    @Provides
    AddUseCase provideAddUseCase(LocalRepository localRepository) {
        return new AddUseCase(localRepository);
    }

    @Provides
    GetUseCase provideUseCase(LocalRepository localRepository) {
        return new GetUseCase(localRepository);
    }

    @Provides
    DeleteUseCase provideDeleteUseCase(LocalRepository localRepository) {
        return new DeleteUseCase(localRepository);
    }

    @Provides
    UpdateUseCase provideUpdateUseCase(LocalRepository localRepository) {
        return new UpdateUseCase(localRepository);
    }

    @Provides
    LatLngWeatherAdapter provideLatLngWeatherAdapter(){
        return new LatLngWeatherAdapter(new LatLngModel());
    }

    @Provides
    WeatherAdapter providerWeatherAdapter(){
        return new WeatherAdapter(new CityGroupModel());
    }
}

