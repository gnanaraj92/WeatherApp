package com.weatherapp.gnanaraj.weatherapplication.Repository.UseCase;

import com.weatherapp.gnanaraj.weatherapplication.Repository.LocalRepository;
import com.weatherapp.gnanaraj.weatherapplication.Repository.SettingEntityModel;

public class AddUseCase {
    private final LocalRepository localRepository;


    public AddUseCase(LocalRepository localRepository) {
        this.localRepository = localRepository;
    }

    public long addSettings(SettingEntityModel settingEntityModel) {
        return localRepository.addSettings(settingEntityModel);
    }

}
