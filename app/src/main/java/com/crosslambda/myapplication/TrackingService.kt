package com.crosslambda.myapplication

import android.util.Log

object TrackingService {
    fun track(name: String) {
        Log.i("TrackingService", "Tracking screen: $name")
    }
}