package com.weatherapp.gnanaraj.weatherapplication.di.Builder;


import com.weatherapp.gnanaraj.weatherapplication.MainActivity.MainActivity;
import com.weatherapp.gnanaraj.weatherapplication.MainActivity.MainActivityModule;
import com.weatherapp.gnanaraj.weatherapplication.MainActivity.SettingDialougeFragment.SettingDialougeFragmentProvider;
import com.weatherapp.gnanaraj.weatherapplication.SplashActivity.SpalshActivityModule;
import com.weatherapp.gnanaraj.weatherapplication.SplashActivity.SplashActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = {MainActivityModule.class, SettingDialougeFragmentProvider.class})
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector(modules = {SpalshActivityModule.class})
    abstract SplashActivity bindSplashActivity();

}
