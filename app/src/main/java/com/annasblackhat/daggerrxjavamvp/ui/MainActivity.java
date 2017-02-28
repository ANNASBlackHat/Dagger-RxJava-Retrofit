package com.annasblackhat.daggerrxjavamvp.ui;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.annasblackhat.daggerrxjavamvp.R;
import com.annasblackhat.daggerrxjavamvp.application.GitApplication;
import com.annasblackhat.daggerrxjavamvp.base.RepositoryPresenter;
import com.annasblackhat.daggerrxjavamvp.databinding.ActivityMainBinding;
import com.annasblackhat.daggerrxjavamvp.model.Repository;
import com.annasblackhat.daggerrxjavamvp.service.GitService;
import com.annasblackhat.daggerrxjavamvp.service.RepositoryViewInterface;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

public class MainActivity extends AppCompatActivity implements RepositoryViewInterface{

    private static final String TAG = "MainActivity";

    @Inject
    GitService service;

    private RepositoryPresenter presenter;
    private ActivityMainBinding binding;
    private RepositoryAdapter repositoryAdapter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Downloading...");
        progressDialog.setCancelable(false);

        ((GitApplication)getApplication())
                .getApiComponent()
                .inject(this);

        presenter = new RepositoryPresenter(this);
        presenter.onCreate();

        binding.recView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
        presenter.fetchRepositories();
        progressDialog.show();
    }

    @Override
    public void completed() {
        Log.e(TAG, "completed: ");
        progressDialog.show();
    }

    @Override
    public void error(String message) {
        Log.e(TAG, "error: "+message);
        progressDialog.dismiss();
    }

    @Override
    public void onNext(List<Repository> repositories) {
        Log.d(TAG, "onNext: ");
        progressDialog.dismiss();
    }

    @Override
    public Observable<List<Repository>> getRepositories() {
        Log.d(TAG, "getRepositories: ");
        return service.getRepositories();
    }
}
