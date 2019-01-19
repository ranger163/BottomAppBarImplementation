package me.inassar.bottomappbarimplementation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        interactions()
    }

    private fun interactions() {
        bottomAppBar.setNavigationOnClickListener {
            startActivity(Intent(this, MenuAndNavigationActivity::class.java))
        }
        fab.setOnClickListener {
            textTv.text = "$count"
            count++
        }
    }

}
