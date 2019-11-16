package com.crosslambda.gdglifecyclebehavior

class PresenterBehavior<T, S>(
    val presenter: S,
    private val contract: Contract<T>
) where T : ContractView, S: ContractPresenter<T> {

    fun onStart() {
        presenter.subscribe(contract.getView()) // PRESENTER
    }

    fun onStop() {
        presenter.unsubscribe() // PRESENTER
    }

    interface Contract<T> {
        fun getView(): T
    }
}