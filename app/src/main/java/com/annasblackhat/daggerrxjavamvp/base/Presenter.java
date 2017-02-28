package com.annasblackhat.daggerrxjavamvp.base;

/**
 * Created by Gideon on 28/02/2017.
 */

public interface Presenter {

    void onCreate();
    void onPause();
    void onResume();
    void onDestroy();

}
