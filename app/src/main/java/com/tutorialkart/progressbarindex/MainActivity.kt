package com.tutorialkart.progressbarindex

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ProgressBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get the references from layout file
        val btnStartProgress = this.button1
        val progressBar: ProgressBar = this.progressBar1

        // when button is clicked, start the task
        btnStartProgress.setOnClickListener { v ->

            // task is run on a thread
            Thread(Runnable {
                // dummy thread mimicking some operation whose progress cannot be tracked

                // display the indefinite progressbar
                this@MainActivity.runOnUiThread(java.lang.Runnable {
                    progressBar.visibility = View.VISIBLE
                })

                // performing some dummy time taking operation
                try {
                    var i=0;
                    while(i<Int.MAX_VALUE){
                        i++
                    }
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }

                // when the task is completed, make progressBar gone
                this@MainActivity.runOnUiThread(java.lang.Runnable {
                    progressBar.visibility = View.GONE
                })
            }).start()
        }
    }
}