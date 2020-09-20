package com.less.rxapp.rx

import android.util.Log
import io.reactivex.Observable


class CashDBLoad {
    fun loadDb(): Observable<Int> {
        return Observable.just(1,2,3)
    }

    fun loadCash(): Observable<Int> {
       // return Observable.just(4,5,6)
        return Observable.empty()
    }

    fun TestConcat() {
        Observable.concat(
            loadCash(),
            loadDb())
            .first(0)
            .subscribe{i -> Log.d(Ex1.TAG, "i: "+i)}
    }

}