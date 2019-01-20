package me.inassar.bottomappbarimplementation

import android.content.Context
import android.widget.Toast
import com.google.android.material.bottomappbar.BottomAppBar

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}