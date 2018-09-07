package com.weatherapp.gnanaraj.weatherapplication.Repository.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.weatherapp.gnanaraj.weatherapplication.Repository.Dao.SettingDao;
import com.weatherapp.gnanaraj.weatherapplication.Repository.SettingEntityModel;
import com.weatherapp.gnanaraj.weatherapplication.Utility.Constants;

@Database(entities = {SettingEntityModel.class},version = 1)
public abstract class AppDataBase  extends RoomDatabase {

    private static AppDataBase instance;

    public static synchronized AppDataBase getInstance(Context context) {
        if (instance == null) {
            instance = Room
                    .databaseBuilder(context.getApplicationContext(), AppDataBase.class, Constants.APP_DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    public abstract SettingDao getSettingDao();

}
