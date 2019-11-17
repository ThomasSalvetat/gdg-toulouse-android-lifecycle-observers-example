package com.crosslambda.gdglifecyclebehavior

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class PresenterBehavior<T, S>(
    val presenter: S,
    private val contract: Contract<T>
) : LifecycleObserver where T : ContractView, S: ContractPresenter<T> {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        presenter.subscribe(contract.getView()) // PRESENTER
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        presenter.unsubscribe() // PRESENTER
    }

    interface Contract<T> {
        fun getView(): T
    }
}