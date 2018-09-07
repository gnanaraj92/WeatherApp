package com.weatherapp.gnanaraj.weatherapplication.MainActivity.SettingDialougeFragment;

import com.weatherapp.gnanaraj.weatherapplication.MainActivity.MainActivityViewModel;
import com.weatherapp.gnanaraj.weatherapplication.Repository.UseCase.AddUseCase;
import com.weatherapp.gnanaraj.weatherapplication.Repository.UseCase.DeleteUseCase;
import com.weatherapp.gnanaraj.weatherapplication.Repository.UseCase.GetUseCase;
import com.weatherapp.gnanaraj.weatherapplication.Repository.UseCase.UpdateUseCase;
import com.weatherapp.gnanaraj.weatherapplication.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class SettingDialougeFragmentModule {
    @Provides
    SettingDialougeViewModule provideSettingDialougeViewModule(SchedulerProvider schedulerProvider, AddUseCase addUseCase, GetUseCase getUseCase, DeleteUseCase deleteUseCase, UpdateUseCase updateUseCase) {
        return new SettingDialougeViewModule(schedulerProvider, addUseCase, getUseCase, deleteUseCase, updateUseCase);

    }
}

