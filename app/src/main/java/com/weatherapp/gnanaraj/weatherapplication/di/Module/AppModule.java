package com.weatherapp.gnanaraj.weatherapplication.di.Module;

import android.app.Application;
import android.content.Context;
import android.provider.SyncStateContract;

import com.weatherapp.gnanaraj.weatherapplication.R;
import com.weatherapp.gnanaraj.weatherapplication.Repository.Dao.SettingDao;
import com.weatherapp.gnanaraj.weatherapplication.Repository.DataStore.LocalDataStore;
import com.weatherapp.gnanaraj.weatherapplication.Repository.LocalRepository;
import com.weatherapp.gnanaraj.weatherapplication.Repository.db.AppDataBase;
import com.weatherapp.gnanaraj.weatherapplication.rx.AppSchedulerProvider;
import com.weatherapp.gnanaraj.weatherapplication.rx.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

@Module
public class AppModule {

    @Provides
    @Singleton
    Context contextProvider(Application application) {return application;}

    @Provides
    @Singleton
    SchedulerProvider schedulerProvider(){return new AppSchedulerProvider();}

    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("Fonts/Roboto-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }

    @Singleton
    @Provides
    SettingDao provideSettingDao(Context context){
        return AppDataBase.getInstance(context).getSettingDao();
    }

    @Singleton
    @Provides
    LocalRepository provideLocalRepository(SettingDao settingDao) {
        return new LocalDataStore(settingDao);
    }

}
