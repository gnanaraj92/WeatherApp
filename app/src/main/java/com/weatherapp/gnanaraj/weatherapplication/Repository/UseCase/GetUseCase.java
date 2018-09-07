package com.weatherapp.gnanaraj.weatherapplication.Repository.UseCase;

import com.weatherapp.gnanaraj.weatherapplication.Repository.LocalRepository;
import com.weatherapp.gnanaraj.weatherapplication.Repository.SettingEntityModel;

public class GetUseCase {
    private final LocalRepository localRepository;

    public GetUseCase(LocalRepository localRepository) {
        this.localRepository = localRepository;
    }

    public SettingEntityModel getSettings(long setting_id) {
        return localRepository.getSettings(setting_id);
    }
}
