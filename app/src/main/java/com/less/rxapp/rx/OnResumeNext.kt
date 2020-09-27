package com.less.rxapp.rx

import android.util.Log
import io.reactivex.Observable
import io.reactivex.ObservableSource

class OnResumeNext {
    val TAG="TAG"

    fun testOnResumeNext2() {
        Observable.just(1,2,3,4,5)
            .map { it/(3-it) }
            .onErrorResumeNext(Observable.range(10,5))
            .subscribe {
                Log.d(TAG, "el: $it" )
            }
    }

}