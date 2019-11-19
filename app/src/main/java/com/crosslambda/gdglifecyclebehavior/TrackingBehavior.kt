package com.crosslambda.gdglifecyclebehavior

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class TrackingBehavior(
    private val contract: Contract
) : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        TrackingService.track(contract.getName()) // TRACKING
    }

    interface Contract {
        fun getName(): String
    }
}