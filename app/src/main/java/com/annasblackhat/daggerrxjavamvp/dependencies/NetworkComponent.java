package com.annasblackhat.daggerrxjavamvp.dependencies;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by Gideon on 28/02/2017.
 */
@Singleton
@Component(modules = {NetworkModule.class})
public interface NetworkComponent {

    Retrofit retrofit();
}
