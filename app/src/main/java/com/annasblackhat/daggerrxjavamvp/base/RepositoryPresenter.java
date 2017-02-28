package com.annasblackhat.daggerrxjavamvp.base;

import android.util.Log;

import com.annasblackhat.daggerrxjavamvp.model.Repository;
import com.annasblackhat.daggerrxjavamvp.service.RepositoryViewInterface;

import java.util.List;

import rx.Observer;

/**
 * Created by Gideon on 28/02/2017.
 */

public class RepositoryPresenter extends BasePresenter implements Observer<List<Repository>> {

    private static final String TAG = "RepositoryPresenter";
    private RepositoryViewInterface repositoryViewInterface;

    public RepositoryPresenter(RepositoryViewInterface repositoryViewInterface) {
        this.repositoryViewInterface = repositoryViewInterface;
    }

    @Override
    public void onCompleted() {
        Log.d(TAG, "onCompleted: ");
        repositoryViewInterface.completed();
    }

    @Override
    public void onError(Throwable e) {
        Log.d(TAG, "onError: ");
        repositoryViewInterface.error(e.getMessage());
    }

    @Override
    public void onNext(List<Repository> repositories) {
        Log.d(TAG, "onNext: ");
        repositoryViewInterface.onNext(repositories);
    }

    public void fetchRepositories() {
        unSubscribeAll();
        subscribe(repositoryViewInterface.getRepositories(), this);
    }
}
