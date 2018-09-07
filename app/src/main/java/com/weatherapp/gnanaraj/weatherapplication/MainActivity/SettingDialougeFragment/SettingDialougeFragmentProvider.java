package com.weatherapp.gnanaraj.weatherapplication.MainActivity.SettingDialougeFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class SettingDialougeFragmentProvider {
    @ContributesAndroidInjector(modules = SettingDialougeFragmentModule.class)
    abstract SettingDialougeFragment getsettingDialougeFragment();
}
