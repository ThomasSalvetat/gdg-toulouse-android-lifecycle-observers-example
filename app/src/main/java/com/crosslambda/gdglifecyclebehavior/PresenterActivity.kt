package com.crosslambda.gdglifecyclebehavior

abstract class PresenterActivity<T, S>(protected val presenter: S) :
    TrackingActivity() where T : ContractView, S: ContractPresenter<T> {

    override fun onStart() {
        super.onStart()
        presenter.subscribe(getView())                                                      // PRESENTER
    }

    abstract fun getView(): T

    override fun onStop() {
        super.onStop()
        presenter.unsubscribe()                                                             // PRESENTER
    }
}