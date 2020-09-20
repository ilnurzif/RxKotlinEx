package com.less.rxapp.rx

import android.util.Log
import io.reactivex.Observable
import io.reactivex.observables.GroupedObservable

data class REvent(val id:Int, val name:String) {
    fun getREventID():Int=id}

class GroupBy {
    val TAG:String= "Debug"

    fun generateREvent(): Observable<REvent> =
        Observable.just(REvent(123,"name1"),
            REvent(123,"name2"),
            REvent(89,"name3"),
            REvent(123,"name4"))
    fun grouped(): Observable<GroupedObservable<Int, REvent>> =
        generateREvent().groupBy {reveent->reveent.id}



    fun printres() {
        Log.d(TAG, "--------example 1 ----------- " )

        grouped()
            .flatMapSingle { x -> x.toList() }
            .subscribe {r-> Log.d(TAG, "printres: "+r) }

        Log.d(TAG, "--------example 2 ----------- " )

        val mySource = Observable.just("a", "bb", "cc", "d", "eee")
        mySource.groupBy{ s -> s.length }
            .flatMapSingle{ group ->
                group.reduce("", { x, y -> if ("" == x) y else x.toString() + ", " + y })
                    .map({ e -> group.getKey().toString() + ": " + e })
            }
            .subscribe{r-> Log.d(TAG, "printres: "+r)}

        /*       val mySource: Observable<String> = Observable.just("a", "bb", "cc", "d", "eee")
               mySource.groupBy({ s -> s.length })
                   .flatMapSingle({ x -> x.toList() })
                   .subscribe{r -> Log.d(TAG, "printres: "+r)}*/
    }

}