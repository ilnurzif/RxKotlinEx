package com.less.rxapp.rx

import android.util.Log
import io.reactivex.Observable

class TakeSkipFirstLastCount {
    fun testTake() {
        Observable.just(1,2,1,3,3,4,5)
            .take(3)
            .subscribe{i -> Log.d(Ex1.TAG, "i: "+i)}
    }

    fun testSkip() {
        Observable.just(1,2,1,3,3,4,5)
            .skip(3)
            .subscribe{i -> Log.d(Ex1.TAG, "i: "+i)}
    }

    fun testFirst() {
        Observable.just(1,2,1,3,3,4,5)
            .firstElement( )
            .subscribe{i -> Log.d(Ex1.TAG, "i: "+i)}
    }

    fun testLast() {
        Observable.just(1,2,1,3,3,4,5)
            .lastElement()
            .subscribe{i -> Log.d(Ex1.TAG, "i: "+i)}
    }


}