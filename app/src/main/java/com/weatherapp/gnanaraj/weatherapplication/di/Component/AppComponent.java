package com.weatherapp.gnanaraj.weatherapplication.di.Component;

import android.app.Application;

import com.weatherapp.gnanaraj.weatherapplication.WeatherApplication;
import com.weatherapp.gnanaraj.weatherapplication.di.Builder.ActivityBuilder;
import com.weatherapp.gnanaraj.weatherapplication.di.Module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityBuilder.class})
public interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }
    void inject(WeatherApplication app);
}
