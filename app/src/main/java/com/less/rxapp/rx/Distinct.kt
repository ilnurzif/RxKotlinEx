package com.less.rxapp.rx

import android.util.Log
import com.less.rxapp.rx.Ex1.Companion.TAG
import io.reactivex.Observable


class Distinct {
    fun testDisctinctUntilChanged() {
        Observable.just(1,2,2,1,3,3,3,4,5,5)
            .distinctUntilChanged()
            .subscribe{i -> Log.d(TAG, "i: "+i)}
    }

    fun testDisctinct() {
        Observable.just(1,2,1,3,2,3,4,5)
            .distinct()
            .subscribe{i -> Log.d(TAG, "i: "+i)}
    }
}