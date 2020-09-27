package com.less.rxapp.rx

import android.util.Log
import io.reactivex.Observable


class Defer {
    val TAG="TAG"

    var now = Observable.defer {
        Observable.just(
            System.currentTimeMillis()
        )
    }

    var nowCreate = Observable.just(System.currentTimeMillis())

    fun test() {
        nowCreate.subscribe { t -> Log.d(TAG, "Just sub1= " + t)}
        Thread.sleep(1000)
        nowCreate.subscribe { t -> Log.d(TAG, "Just sub2= " + t) }

        now.subscribe { t -> Log.d(TAG, "Defer sub1= " + t)}
        Thread.sleep(1000)
        now.subscribe { t -> Log.d(TAG, "Defer sub2= " + t) }
    }

}