package com.annasblackhat.daggerrxjavamvp.base;

import android.util.Log;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Gideon on 28/02/2017.
 */

public abstract  class BasePresenter implements Presenter{

    private static final String TAG = "BasePresenter";
    private CompositeSubscription compositeSubscription;

    @Override
    public void onCreate() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {
        if(compositeSubscription == null || compositeSubscription.isUnsubscribed()){
            compositeSubscription = new CompositeSubscription();
        }
    }

    @Override
    public void onDestroy() {
        unSubscribeAll();
    }

    protected void unSubscribeAll(){
        if(compositeSubscription != null){
            compositeSubscription.unsubscribe();
            compositeSubscription.clear();
        }
    }

    protected <T> void subscribe(Observable<T> observable, Observer<T> observer){
        Subscription subscription = observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.computation())
                .subscribe(observer);
        compositeSubscription.add(subscription);
        Log.d(TAG, "subscribe: "+String.valueOf(compositeSubscription == null));
    }

}
