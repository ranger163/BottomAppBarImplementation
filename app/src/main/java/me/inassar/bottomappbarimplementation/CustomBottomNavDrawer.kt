package me.inassar.bottomappbarimplementation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_custom_bottom_nav_drawer.*

class CustomBottomNavDrawer : BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_custom_bottom_nav_drawer, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        navigationView.setNavigationItemSelectedListener {
            dismiss()
            context!!.toast("open ${it.title} fragment")
            true
        }

        navDismissBtn.setOnClickListener {
            dismiss()
        }

    }

}