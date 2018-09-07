package com.weatherapp.gnanaraj.weatherapplication.Repository.UseCase;

import com.weatherapp.gnanaraj.weatherapplication.Repository.LocalRepository;
import com.weatherapp.gnanaraj.weatherapplication.Repository.SettingEntityModel;

public class DeleteUseCase {
    private final LocalRepository localRepository;

    public DeleteUseCase(LocalRepository localRepository) {
        this.localRepository = localRepository;
    }

    public void deleteSettings(SettingEntityModel settingEntityModel) {
        localRepository.deleteSettings(settingEntityModel);
    }

    public void deleteBySettingsId(long setting_id) {
        localRepository.deleteBySettingsId(setting_id);
    }
}
