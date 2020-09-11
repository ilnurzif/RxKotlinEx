package com.less.rxapp.rx

import android.util.Log
import com.less.rxapp.rx.Ex1.Companion.TAG
import io.reactivex.Observable
import io.reactivex.Observable.interval
import io.reactivex.functions.BiFunction
import java.util.concurrent.TimeUnit

class WithLatestFrom {
    fun test() {
       val fast:Observable<String> = interval(1, TimeUnit.SECONDS)
           .map { x-> "F"+x }
           .delay(10, TimeUnit.SECONDS)
           .startWith("FX")

       val slow: Observable<String> = interval(3, TimeUnit.SECONDS)
           .map { x -> "S"+x }
        slow
            .withLatestFrom(fast, BiFunction{s:String , f:String -> s+":"+f})
            .forEach{x -> Log.d(TAG, x)}
    }
}