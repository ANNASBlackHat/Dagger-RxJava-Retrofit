package com.annasblackhat.daggerrxjavamvp.service;

import com.annasblackhat.daggerrxjavamvp.model.Repository;

import java.util.List;

import rx.Observable;

/**
 * Created by Gideon on 28/02/2017.
 */

public interface RepositoryViewInterface {
    void completed();

    void error(String message);

    void onNext(List<Repository> repositories);

    Observable<List<Repository>> getRepositories();
}
