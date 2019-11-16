package com.crosslambda.gdglifecyclebehavior

import android.app.Activity
import android.widget.TextView

class CustomHeaderBehavior(
    private val contract: Contract
) {

    fun onCreate(activity: Activity) {
        activity.apply {
            findViewById<TextView>(R.id.header_custom_title).text =
                getString(contract.getCustomTitle()) // HEADER
        }
    }

    interface Contract {
        fun getCustomTitle(): Int
    }
}