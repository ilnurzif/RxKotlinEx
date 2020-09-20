package com.less.rxapp.rx

import android.util.Log
import io.reactivex.Observable

class TakeWhile {
    fun testtakeWhile() {
        Observable.just(1,2,2,1,3,3,3,4,5,5)
            .takeWhile{t->t<3}
            .subscribe{i -> Log.d(Ex1.TAG, "i: "+i)}
    }

    fun testtakeUntil() {
        Observable.just(1,2,2,1,3,3,3,4,5,5)
            .takeUntil{t->t>3}
            .subscribe{i -> Log.d(Ex1.TAG, "i: "+i)}
    }
}