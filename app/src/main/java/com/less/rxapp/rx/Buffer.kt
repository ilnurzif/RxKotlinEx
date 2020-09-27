package com.less.rxapp.rx

import android.util.Log
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import java.util.concurrent.TimeUnit


class Buffer {
    val TAG="TAG"
    fun testBuffer() {
        Observable
            .range(1,7)
            .buffer(3)
            .subscribe { list: List<Int> -> Log.d(TAG, "list: "+list) }
    }
/////////////////////////////////////////////////////////////
    fun testBufferNN() {
        Observable
            .range(1,7)
            .buffer(1,1)
            .subscribe { list: List<Int> -> Log.d(TAG, "list: "+list) }
    }
/////////////////////////////////////////////////////////////
    fun testBufferWithIterable() {
        Observable
            .range(1,7)
            .buffer(1,2)
            .flatMapIterable { list->list }
            .subscribe { list -> Log.d(TAG, "list: "+list) }
    }

    /////////////////////////////////////////////////////
    fun names() :Observable<String> = Observable.just(
        "Mary","Patricia","Linde",
        "Barbara","Eliza","Jeni",
        "Maria","Susan","Margo",
        "Doroty");

    fun absoluteDelays() : Observable<Long> = Observable.just(
        0.1,0.6,0.9,1.1,3.3,
        3.4,3.5,3.6,4.4,4.8
    ).map { d ->  ((d*1_000).toLong()) }

    fun delayedNames() : Observable<String> = Observable
        .zip(
            names(),
            absoluteDelays(),
            BiFunction<String, Long, Observable<String>>()
            { n,d ->  Observable.just(n).delay(d,TimeUnit.MILLISECONDS)}
            )
        .flatMap { o -> o }

   fun testBuffer2() =  delayedNames()
       .buffer(1,TimeUnit.SECONDS)
       .subscribe { el -> Log.d(TAG, "el: "+el) }
}