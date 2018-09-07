package com.weatherapp.gnanaraj.weatherapplication.Repository;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class SettingEntityModel {

    @PrimaryKey(autoGenerate = false)
    private long setting_id;

    @ColumnInfo(name = "setting_name")
    private String settingName;

    @ColumnInfo(name = "setting_value")
    private String settingValue;

    public SettingEntityModel(long setting_id, String settingName, String settingValue) {
        this.setting_id = setting_id;
        this.settingName = settingName;
        this.settingValue = settingValue;
    }

    public long getSetting_id() {
        return setting_id;
    }

    public void setSetting_id(long setting_id) {
        this.setting_id = setting_id;
    }

    public String getSettingName() {
        return settingName;
    }

    public void setSettingName(String settingName) {
        this.settingName = settingName;
    }

    public String getSettingValue() {
        return settingValue;
    }

    public void setSettingValue(String settingValue) {
        this.settingValue = settingValue;
    }
}
