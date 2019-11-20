package com.crosslambda.gdglifecyclebehavior

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import io.reactivex.disposables.CompositeDisposable

class ReactiveBehavior(
    private val contract: Contract
) : LifecycleObserver {
    private val compositeDisposable = CompositeDisposable()

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        contract.startObserve((compositeDisposable))
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        compositeDisposable.clear()
    }

    interface Contract {
        fun startObserve(compositeDisposable: CompositeDisposable)
    }
}