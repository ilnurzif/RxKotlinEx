package com.less.rxapp.rx

import android.util.Log
import io.reactivex.Observable
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException


class Retry {
    val TAG="TAG"

    fun testRetry() {
            Observable.defer {
                Log.d(TAG, "Start defer")
                Thread.sleep(2000)
                Log.d(TAG, "fin sllep")
                Observable.just(1)
            }
            .doOnNext{i -> Log.d(TAG, "After Observable.defer ="+i)}
            .timeout(1, TimeUnit.SECONDS)
            .doOnNext{i -> Log.d(TAG, "After timeout ="+i)}
            .retry(10)
            .doOnNext{i -> Log.d(TAG, "After retry ="+i)}
            .subscribe{el -> Log.d(TAG, "el: "+el)};
    }

    fun testRetryWhen() {

    }
}