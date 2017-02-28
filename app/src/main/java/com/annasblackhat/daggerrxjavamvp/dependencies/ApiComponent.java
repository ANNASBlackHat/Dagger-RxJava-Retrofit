package com.annasblackhat.daggerrxjavamvp.dependencies;

import com.annasblackhat.daggerrxjavamvp.ui.MainActivity;

import dagger.Component;

/**
 * Created by Gideon on 28/02/2017.
 */

@CustomScope
@Component(modules = ApiModule.class, dependencies = NetworkComponent.class)
public interface ApiComponent {

    void inject(MainActivity activity);

}
