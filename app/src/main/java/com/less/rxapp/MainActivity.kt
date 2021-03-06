package com.less.rxapp

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.less.rxapp.rx.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
     /*       Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()*/
           // Ex1.ex1()
          //   Ex1.exFlatMap()
          //  Ex1.concatMap()
          //  Ex1.mergeEx()
        //     Zip().resultFun()
         //   CombineLatest().testConbineLatest()
         //   WithLatestFrom().test()
            //Scan().testScan()
         //   Scan().testReduce()
         //   Scan().testCollectInto()
         //   Distinct().testDisctinct()
         //   Distinct().testDisctinctUntilChanged()
         //   TakeWhile().testtakeWhile();
         //   TakeWhile().testtakeUntil();
        //    CashDBLoad().TestConcat()
        //    Buffer().testBuffer()
       //     Buffer().testBufferNN()
         //   Buffer().testBufferWithIterable()
            //   Buffer().testBuffer2()
        //    OnResumeNext().testOnResumeNext2()
           // Defer().test()
         //   TimeOut().testTimeOut()
            Retry().testRetry()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}