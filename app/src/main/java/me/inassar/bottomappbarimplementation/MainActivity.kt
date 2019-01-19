package me.inassar.bottomappbarimplementation

import android.os.Bundle
import android.widget.Toast
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
            Toast.makeText(this, "Navigation menu clicked", Toast.LENGTH_SHORT).show()
        }
        fab.setOnClickListener {
            textTv.text = "$count"
            count++
        }
    }

}
