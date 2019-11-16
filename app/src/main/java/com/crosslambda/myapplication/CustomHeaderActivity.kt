package com.crosslambda.myapplication

import android.os.Bundle
import android.widget.TextView

abstract class CustomHeaderActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findViewById<TextView>(R.id.header_custom_title).text =
            getString(getCustomTitle()) // HEADER
    }

    abstract fun getCustomTitle(): Int
}