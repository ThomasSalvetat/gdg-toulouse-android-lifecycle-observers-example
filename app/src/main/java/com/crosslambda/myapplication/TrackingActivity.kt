package com.crosslambda.myapplication

import android.os.Bundle

abstract class TrackingActivity : CustomHeaderActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TrackingService.track(getName())                // TRACKING
    }

    abstract fun getName(): String
}