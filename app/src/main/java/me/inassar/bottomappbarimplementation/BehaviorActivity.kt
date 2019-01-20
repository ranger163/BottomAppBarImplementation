package me.inassar.bottomappbarimplementation

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_behavior.*
import me.inassar.bottomappbarimplementation.R.drawable.*
import me.inassar.bottomappbarimplementation.R.menu.bottomappbar_menu_primary
import me.inassar.bottomappbarimplementation.R.menu.bottomappbar_menu_secondary

class BehaviorActivity : AppCompatActivity() {

    private var currentFabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
    private val addVisibilityChanged: FloatingActionButton.OnVisibilityChangedListener =
            object : FloatingActionButton.OnVisibilityChangedListener() {
                override fun onShown(fab: FloatingActionButton?) {
                    super.onShown(fab)
                }

                @SuppressLint("NewApi")
                override fun onHidden(fab: FloatingActionButton?) {
                    super.onHidden(fab)
                    bottomAppBar.toggleFab()
                    bottomAppBar.replaceMenu(
                            if (currentFabAlignmentMode == BottomAppBar.FAB_ALIGNMENT_MODE_CENTER)
                                bottomappbar_menu_secondary
                            else bottomappbar_menu_primary
                    )
                    fab?.setImageDrawable(
                            if (currentFabAlignmentMode == BottomAppBar.FAB_ALIGNMENT_MODE_CENTER)
                                getDrawable(ic_reply_white_24dp)
                            else getDrawable(ic_add_white_24dp)
                    )
                    fab?.show()
                }
            }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_behavior)

        setSupportActionBar(bottomAppBar)

        interactions()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.bottomappbar_menu_primary, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                BottomNavigationDrawerFragment().show(supportFragmentManager,
                        BottomNavigationDrawerFragment().tag)
            }
        }
        return true
    }

    @SuppressLint("NewApi")
    private fun interactions() {
        toggleBtn.setOnClickListener {
            fab.hide(addVisibilityChanged)
            invalidateOptionsMenu()
            bottomAppBar.navigationIcon = if (bottomAppBar.navigationIcon != null) null
            else getDrawable(ic_menu_white_24dp)
            when (textTv.text) {
                getString(R.string.primary_screen) ->
                    textTv.text = getString(R.string.secondary_screen)
                getString(R.string.secondary_screen) ->
                    textTv.text = getString(R.string.primary_screen)
            }
        }

        // Handling click events on menu items
        bottomAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.app_bar_search -> toast("${it.title} clicked")
                R.id.app_bar_mail -> toast("${it.title} clicked")
                R.id.app_bar_delete -> toast("${it.title} clicked")
                R.id.app_bar_archive -> toast("${it.title} clicked")
            }
            true
        }
    }

    private fun BottomAppBar.toggleFab() {
        currentFabAlignmentMode = fabAlignmentMode
        fabAlignmentMode = currentFabAlignmentMode.xor(1)
    }

}