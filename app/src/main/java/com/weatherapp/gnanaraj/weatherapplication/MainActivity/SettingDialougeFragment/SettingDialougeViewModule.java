package com.weatherapp.gnanaraj.weatherapplication.MainActivity.SettingDialougeFragment;

import com.weatherapp.gnanaraj.weatherapplication.Base.BaseViewModel;
import com.weatherapp.gnanaraj.weatherapplication.Repository.UseCase.AddUseCase;
import com.weatherapp.gnanaraj.weatherapplication.Repository.UseCase.DeleteUseCase;
import com.weatherapp.gnanaraj.weatherapplication.Repository.UseCase.GetUseCase;
import com.weatherapp.gnanaraj.weatherapplication.Repository.UseCase.UpdateUseCase;
import com.weatherapp.gnanaraj.weatherapplication.rx.SchedulerProvider;

public class SettingDialougeViewModule extends BaseViewModel<SettingDialougeNavigator> {

    public SettingDialougeViewModule(SchedulerProvider schedulerProvider, AddUseCase addUseCase, GetUseCase getUseCase, DeleteUseCase deleteUseCase, UpdateUseCase updateUseCase) {
        super(schedulerProvider, addUseCase, getUseCase, deleteUseCase, updateUseCase);
    }

    public void close(){
        getNavigator().dismissDialog();
    }
}
