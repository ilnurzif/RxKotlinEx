package com.less.rxapp.rx



import android.system.Os.accept
import android.util.Log
import io.reactivex.Observable
import io.reactivex.Observable.empty
import io.reactivex.Observable.just
import io.reactivex.functions.Consumer
import kotlinx.coroutines.delay
import java.util.concurrent.TimeUnit

class Ex1 {
    companion object {
        val TAG="Debug"
        fun ex1() {
            Observable
                .just(8,9,10)
              //  .doOnNext{i -> Log.d(TAG, "i="+i)}
                .filter{i->i % 3 > 0}
            //    .doOnNext{i -> Log.d(TAG, "mi="+i)}
                .map { i -> "#"+i*10 }
           //     .doOnNext{i -> Log.d(TAG, "mi="+i)}
                .filter { s -> s.length <4 }
                .doOnNext{i -> Log.d(TAG, "mi="+i)}
                .subscribe()
        }

        enum class Sound{DI, DAH}

         fun toMorseCode(ch:Char): Observable<Char> {
            when(ch) {
                'a' -> return  just('A')
                'b' -> return  just('B')
            }
            return  empty()
        }

        fun toStr(str:Char): Observable<String> {
            when(str) {
                'a' -> return  just("A").delay(500, TimeUnit.MILLISECONDS)
                'b' -> return  just("B").delay(300, TimeUnit.MILLISECONDS)
            }
            return  empty()
        }

        fun exFlatMap() {
            just('a','b','r')
               // .doOnNext{s->Log.d(TAG, "ch="+s)}
                .flatMap{ ch -> toMorseCode(ch) }
                .doOnNext{s->Log.d(TAG, "val="+s)}
                .subscribe()
        }

        fun concatMap() {
           just('a','b','c')
         //  .flatMap { ch -> toStr(ch) }
           .concatMap { ch -> toStr(ch) }
           .doOnNext{s->Log.d(TAG, "val="+s)}
               .subscribe()
        }

      fun mergeEx() {
          val th1 = Observable.just("a1").delay ( 1000, TimeUnit.MILLISECONDS)
          val th2  = Observable.just("a2").delay ( 200, TimeUnit.MILLISECONDS)
          val th3  = Observable.just("a3").delay ( 300, TimeUnit.MILLISECONDS)
          val all=Observable.merge(th1,th2,th3)
              .doOnNext{s-> Log.d(TAG, "mergeEx: "+s)}
              .subscribe()
      }
    }
}