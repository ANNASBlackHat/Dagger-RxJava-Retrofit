package com.annasblackhat.daggerrxjavamvp.service;

import com.annasblackhat.daggerrxjavamvp.model.Repository;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Gideon on 28/02/2017.
 */

public interface GitService {

    @GET("/users/annasblackhat/repos")
    Observable<List<Repository>> getRepositories();

}
