package me.inassar.bottomappbarimplementation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_menu_and_navigation.*

class MenuAndNavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_and_navigation)

        bottomAppBar()
    }

    private fun bottomAppBar() {
        // Setting menu to bottom app bar
        bottomAppBar.replaceMenu(R.menu.navigation_menu)

        // Handling menu item clicks
        bottomAppBar.setOnMenuItemClickListener {
            when (it!!.itemId) {
                R.id.app_bar_fav -> toast("Fav menu item is clicked!")
                R.id.app_bar_search -> toast("Search menu item is clicked!")
                R.id.app_bar_settings -> toast("Settings item is clicked!")
            }
            true
        }

        // Opening bottom navigation drawer
        bottomAppBar.setNavigationOnClickListener {
            BottomNavigationDrawerFragment().show(supportFragmentManager,
                    BottomNavigationDrawerFragment().tag)
        }
    }

}
