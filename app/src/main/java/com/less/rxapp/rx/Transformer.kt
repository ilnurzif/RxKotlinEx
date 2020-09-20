package com.less.rxapp.rx

import android.util.Log
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class Transformer<T, U> {
    fun  odd(v:String): Observable<Int> =
        Observable.just(v)
            .map { str-> str.length}

/*
    fun <T> applySchedulers(): Transformer<T, T>? {
        return Transformer{ observable ->
            observable.subscribeOn(Schedulers.io())
                .observeOn{AndroidSchedulers.mainThread()}
        }
    }
*/

    fun test() {
        Observable.just("1","123","1234")
            .map{str->odd(str)}
            .flatMapSingle { x -> x.toList() }
            .subscribe { i-> Log.d("TAG", "test: "+i) }
    }


}