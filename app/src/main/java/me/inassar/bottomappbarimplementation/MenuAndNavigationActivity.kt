package me.inassar.bottomappbarimplementation

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_menu_and_navigation.*

class MenuAndNavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_and_navigation)

        setSupportActionBar(bottomAppBar)

        interactions()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.navigation_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> BottomNavigationDrawerFragment().show(supportFragmentManager,
                    BottomNavigationDrawerFragment().tag)
            R.id.app_bar_fav -> toast("Fav menu item is clicked!")
            R.id.app_bar_search -> toast("Search menu item is clicked!")
            R.id.app_bar_settings -> toast("Settings item is clicked!")
        }
        return true
    }

    private fun interactions() {
        fab.setOnClickListener {
            startActivity(Intent(this, BehaviorActivity::class.java))
        }
    }
}
