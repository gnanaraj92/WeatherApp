package com.weatherapp.gnanaraj.weatherapplication.Repository.DataStore;

import com.weatherapp.gnanaraj.weatherapplication.Repository.Dao.SettingDao;
import com.weatherapp.gnanaraj.weatherapplication.Repository.LocalRepository;
import com.weatherapp.gnanaraj.weatherapplication.Repository.SettingEntityModel;

public class LocalDataStore implements LocalRepository{
    SettingDao settingDao;

    public LocalDataStore(SettingDao settingDao) {
        this.settingDao = settingDao;
    }

    @Override
    public long addSettings(SettingEntityModel settingEntityModel) {
        return settingDao.addSettings(settingEntityModel);
    }

    @Override
    public void updateSettings(SettingEntityModel settingEntityModel) {
        settingDao.updateSettings(settingEntityModel);
    }

    @Override
    public void deleteSettings(SettingEntityModel settingEntityModel) {
            settingDao.deleteSettings(settingEntityModel);
    }

    @Override
    public void deleteBySettingsId(long setting_id) {
        settingDao.deleteBySettingsId(setting_id);
    }

    @Override
    public SettingEntityModel getSettings(long setting_id) {
        return settingDao.getSettings(setting_id);
    }
}
