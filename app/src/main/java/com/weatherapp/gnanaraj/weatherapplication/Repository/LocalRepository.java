package com.weatherapp.gnanaraj.weatherapplication.Repository;

public interface LocalRepository {
    long addSettings(SettingEntityModel settingEntityModel);

    void updateSettings(SettingEntityModel settingEntityModel);

    void deleteSettings(SettingEntityModel settingEntityModel);

    void deleteBySettingsId(long setting_id);

    SettingEntityModel getSettings(long setting_id);
}
