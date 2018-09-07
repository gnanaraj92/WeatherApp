package com.weatherapp.gnanaraj.weatherapplication.SplashActivity;

import com.weatherapp.gnanaraj.weatherapplication.Repository.LocalRepository;
import com.weatherapp.gnanaraj.weatherapplication.Repository.RemoteRepository;
import com.weatherapp.gnanaraj.weatherapplication.Repository.UseCase.AddUseCase;
import com.weatherapp.gnanaraj.weatherapplication.Repository.UseCase.DeleteUseCase;
import com.weatherapp.gnanaraj.weatherapplication.Repository.UseCase.GetUseCase;
import com.weatherapp.gnanaraj.weatherapplication.Repository.UseCase.SyncUseCase;
import com.weatherapp.gnanaraj.weatherapplication.Repository.UseCase.UpdateUseCase;
import com.weatherapp.gnanaraj.weatherapplication.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class SpalshActivityModule {

    @Provides
    SplashActivityViewModel provideProducerDetailsViewModel(SchedulerProvider schedulerProvider,AddUseCase addUseCase, GetUseCase getUseCase, DeleteUseCase deleteUseCase, UpdateUseCase updateUseCase) {
        return new SplashActivityViewModel(schedulerProvider, addUseCase, getUseCase, deleteUseCase, updateUseCase);
    }

    @Provides
    AddUseCase provideAddUseCase(LocalRepository localRepository) {
        return new AddUseCase(localRepository);
    }

    @Provides
    GetUseCase provideUseCase(LocalRepository localRepository) {
        return new GetUseCase(localRepository);
    }

    @Provides
    DeleteUseCase provideDeleteUseCase(LocalRepository localRepository) {
        return new DeleteUseCase(localRepository);
    }

    @Provides
    UpdateUseCase provideUpdateUseCase(LocalRepository localRepository) {
        return new UpdateUseCase(localRepository);
    }


}
