package com.weatherapp.gnanaraj.weatherapplication.Repository.UseCase;

import com.weatherapp.gnanaraj.weatherapplication.Repository.LocalRepository;
import com.weatherapp.gnanaraj.weatherapplication.Repository.SettingEntityModel;

public class UpdateUseCase {
    private final LocalRepository localRepository;


    public UpdateUseCase(LocalRepository localRepository) {
        this.localRepository = localRepository;
    }

    public void updateSettings(SettingEntityModel settingEntityModel) {
        localRepository.updateSettings(settingEntityModel);
    }


}
