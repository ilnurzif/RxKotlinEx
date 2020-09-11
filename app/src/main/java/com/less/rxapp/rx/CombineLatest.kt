package com.less.rxapp.rx

import android.util.Log
import com.less.rxapp.rx.Ex1.Companion.TAG
import io.reactivex.Observable
import io.reactivex.Observable.interval
import io.reactivex.functions.BiFunction
import java.util.concurrent.TimeUnit


class CombineLatest {
    fun testConbineLatest() {
        Observable.combineLatest(
            interval(2, TimeUnit.SECONDS).map{x -> "S=$x"},
            interval(5, TimeUnit.SECONDS).map{x -> "S=$x"},
            BiFunction{s: String, f:String -> f+" : "+s}
        ).forEach{x -> Log.d(TAG,x)}
    }
}