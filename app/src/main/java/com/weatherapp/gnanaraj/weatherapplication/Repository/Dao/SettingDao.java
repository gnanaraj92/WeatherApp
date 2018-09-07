package com.weatherapp.gnanaraj.weatherapplication.Repository.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.weatherapp.gnanaraj.weatherapplication.Repository.SettingEntityModel;

import io.reactivex.Single;

@Dao
public interface SettingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long addSettings(SettingEntityModel settingEntityModel);

    @Update
    void updateSettings(SettingEntityModel settingEntityModel);

    @Delete
    void deleteSettings(SettingEntityModel settingEntityModel);

    @Query("DELETE FROM SettingEntityModel WHERE setting_id=:setting_id")
    void deleteBySettingsId(long setting_id);

    @Query("SELECT * FROM SettingEntityModel WHERE setting_id = :setting_id ORDER BY setting_id DESC")
    SettingEntityModel getSettings(long setting_id);

}
