package com.weatherapp.gnanaraj.weatherapplication.Base;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;

import com.weatherapp.gnanaraj.weatherapplication.Repository.UseCase.AddUseCase;
import com.weatherapp.gnanaraj.weatherapplication.Repository.UseCase.DeleteUseCase;
import com.weatherapp.gnanaraj.weatherapplication.Repository.UseCase.GetUseCase;
import com.weatherapp.gnanaraj.weatherapplication.Repository.UseCase.UpdateUseCase;
import com.weatherapp.gnanaraj.weatherapplication.rx.SchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Gnanaraj on 05-08-2018.
 */

public abstract class BaseViewModel<N> extends ViewModel {
    private N mNavigator;
    private final SchedulerProvider mSchedulerProvider;
    private final ObservableBoolean mIsLoading = new ObservableBoolean(false);
    private final GetUseCase getUseCase;
    private final AddUseCase addUseCase;
    private final DeleteUseCase deleteUseCase;
    private final UpdateUseCase updateUseCase;
    private final CompositeDisposable mCompositeDisposable;

    public BaseViewModel(SchedulerProvider schedulerProvider,AddUseCase addUseCase,GetUseCase getUseCase,DeleteUseCase deleteUseCase,UpdateUseCase updateUseCase) {
        this.mSchedulerProvider = schedulerProvider;
        this.mCompositeDisposable = new CompositeDisposable();
        this.addUseCase=addUseCase;
        this.getUseCase=getUseCase;
        this.deleteUseCase = deleteUseCase;
        this.updateUseCase = updateUseCase;
    }


    public void setNavigator(N navigator) {
        this.mNavigator = navigator;
    }

    public N getNavigator() {
        return mNavigator;
    }

    public SchedulerProvider getSchedulerProvider() {
        return mSchedulerProvider;
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

    public ObservableBoolean getIsLoading() {
        return mIsLoading;
    }

    public void setIsLoading(boolean isLoading) {
        mIsLoading.set(isLoading);
    }

    public GetUseCase getUseCase() {
        return getUseCase;
    }

    public AddUseCase addUseCase() {
        return addUseCase;
    }

    public DeleteUseCase deleteUseCase()
    {
        return deleteUseCase;
    }

    public UpdateUseCase updateUseCase() {
        return updateUseCase;
    }


    @Override
    protected void onCleared() {
        mCompositeDisposable.dispose();
        super.onCleared();
    }
}
