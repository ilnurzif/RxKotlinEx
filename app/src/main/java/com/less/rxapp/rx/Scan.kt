package com.less.rxapp.rx

import android.util.Log
import com.less.rxapp.rx.Ex1.Companion.TAG
import io.reactivex.Observable
import io.reactivex.functions.BiConsumer
import java.lang.StringBuilder


class Scan {
    fun testScan() {
      Observable.range(1,4)
          .scan{t,c->t+c}
          .subscribe{t -> Log.d(TAG, "scan total = "+t)}
    }

    fun testReduce() {
        Observable.range(1,4)
            .reduce{t,c->t+c}
            .subscribe{t -> Log.d(TAG, "reduce total = "+t)}
    }

    fun testCollectInto() {
        Observable.range(1,10)
         .collectInto(StringBuilder(), BiConsumer { str, ch ->  str.append(ch) })
            .map { t: StringBuilder -> t.toString() }
            .subscribe{t -> Log.d(TAG, "sum: "+t)}
    }
}