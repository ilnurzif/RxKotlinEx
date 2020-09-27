package com.less.rxapp.rx

import android.util.Log
import io.reactivex.Observable
import java.util.concurrent.TimeUnit


class TimeOut {
    val TAG="TAG"

    fun testTimeOut() {
        Observable.just("event")
            .delay(200, TimeUnit.MILLISECONDS)
            .timeout(100, TimeUnit.MILLISECONDS)
            .onErrorResumeNext(Observable.just("TimeOutError"))
            .subscribe{el -> Log.d(TAG, "el: "+el)};
    }
}