package me.inassar.bottomappbarimplementation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.navigation.NavigationView

class BottomNavigationDrawerFragment : BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_bottomsheet, container, false)
        navDrawerItemClick(view)
        return view
    }

    private fun navDrawerItemClick(view: View) {
        val navView = view.findViewById(R.id.navigationView) as NavigationView
        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav1 -> context?.toast("${it.title} clicked")
                R.id.nav2 -> context?.toast("${it.title} clicked")
                R.id.nav3 -> context?.toast("${it.title} clicked")
            }
            true
        }
    }
}