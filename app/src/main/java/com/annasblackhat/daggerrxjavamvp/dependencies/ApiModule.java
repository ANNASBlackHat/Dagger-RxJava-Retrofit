package com.annasblackhat.daggerrxjavamvp.dependencies;

import com.annasblackhat.daggerrxjavamvp.service.GitService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Gideon on 28/02/2017.
 */

@Module
public class ApiModule {

    @Provides @CustomScope
    GitService getProvideGitService(Retrofit retrofit){
        return retrofit.create(GitService.class);
    }
}
