package com.crosslambda.gdglifecyclebehavior

class TrackingBehavior(
    private val contract: Contract
) {

    fun onCreate() {
        TrackingService.track(contract.getName()) // TRACKING
    }

    interface Contract {
        fun getName(): String
    }
}