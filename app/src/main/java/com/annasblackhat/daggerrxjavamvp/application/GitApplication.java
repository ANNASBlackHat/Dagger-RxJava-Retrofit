package com.annasblackhat.daggerrxjavamvp.application;

import android.app.Application;

import com.annasblackhat.daggerrxjavamvp.dependencies.ApiComponent;
import com.annasblackhat.daggerrxjavamvp.dependencies.DaggerApiComponent;
import com.annasblackhat.daggerrxjavamvp.dependencies.DaggerNetworkComponent;
import com.annasblackhat.daggerrxjavamvp.dependencies.NetworkComponent;
import com.annasblackhat.daggerrxjavamvp.dependencies.NetworkModule;
import com.annasblackhat.daggerrxjavamvp.model.Constant;

/**
 * Created by Gideon on 28/02/2017.
 */

public class GitApplication extends Application {

    private ApiComponent apiComponent;

    @Override
    public void onCreate() {
        resolveDepenency();
        super.onCreate();
    }

    private void resolveDepenency() {
        apiComponent = DaggerApiComponent.builder()
                .networkComponent(getNetworkComponent())
                .build();
    }

    public NetworkComponent getNetworkComponent() {
        NetworkComponent networkComponent = DaggerNetworkComponent.builder()
                .networkModule(new NetworkModule(Constant.BASE_URL))
                .build();
        return networkComponent;
    }

    public ApiComponent getApiComponent() {
        return apiComponent;
    }
}
