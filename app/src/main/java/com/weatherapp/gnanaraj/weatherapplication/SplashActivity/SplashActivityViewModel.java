package com.weatherapp.gnanaraj.weatherapplication.SplashActivity;

import com.weatherapp.gnanaraj.weatherapplication.Base.BaseViewModel;
import com.weatherapp.gnanaraj.weatherapplication.Repository.LocalRepository;
import com.weatherapp.gnanaraj.weatherapplication.Repository.RemoteRepository;
import com.weatherapp.gnanaraj.weatherapplication.Repository.SettingEntityModel;
import com.weatherapp.gnanaraj.weatherapplication.Repository.UseCase.AddUseCase;
import com.weatherapp.gnanaraj.weatherapplication.Repository.UseCase.DeleteUseCase;
import com.weatherapp.gnanaraj.weatherapplication.Repository.UseCase.GetUseCase;
import com.weatherapp.gnanaraj.weatherapplication.Repository.UseCase.SyncUseCase;
import com.weatherapp.gnanaraj.weatherapplication.Repository.UseCase.UpdateUseCase;
import com.weatherapp.gnanaraj.weatherapplication.Utility.Constants;
import com.weatherapp.gnanaraj.weatherapplication.rx.SchedulerProvider;

import dagger.Provides;

public class SplashActivityViewModel extends BaseViewModel<SplashNavigator>{

    public SplashActivityViewModel(SchedulerProvider schedulerProvider, AddUseCase addUseCase, GetUseCase getUseCase, DeleteUseCase deleteUseCase, UpdateUseCase updateUseCase) {
        super(schedulerProvider, addUseCase, getUseCase, deleteUseCase, updateUseCase);
    }

    public void LoadSettings(){
        if(getUseCase().getSettings(Constants.SETTING_ID)==null) {
            SettingEntityModel settingEntityModel = new SettingEntityModel(Constants.SETTING_ID, Constants.STR_TEMP_UNIT, Constants.STR_UNIT_METRIC);
            addUseCase().addSettings(settingEntityModel);
        }

    }


}
