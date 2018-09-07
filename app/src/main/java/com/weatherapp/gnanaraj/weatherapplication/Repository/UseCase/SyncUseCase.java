package com.weatherapp.gnanaraj.weatherapplication.Repository.UseCase;

import com.weatherapp.gnanaraj.weatherapplication.Repository.RemoteRepository;

/**
 * Responsible for syncing a comment with remote repository.
 */
public class SyncUseCase {
    private final RemoteRepository remoteCommentRepository;

    public SyncUseCase(RemoteRepository remoteCommentRepository) {
        this.remoteCommentRepository = remoteCommentRepository;
    }
}