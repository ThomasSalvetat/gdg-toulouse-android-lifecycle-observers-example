package com.crosslambda.gdglifecyclebehavior

import android.app.Activity
import android.widget.TextView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class CustomHeaderBehavior(
    private val contract: CustomHeaderBehavior.Contract,
    private val activity: Activity
) : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        activity.apply {
            findViewById<TextView>(R.id.header_custom_title).text =
                getString(contract.getCustomTitle()) // HEADER
        }
    }

    interface Contract {
        fun getCustomTitle(): Int
    }
}