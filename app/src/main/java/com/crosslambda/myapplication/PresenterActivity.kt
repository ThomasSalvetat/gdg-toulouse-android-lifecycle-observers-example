package com.crosslambda.myapplication

abstract class PresenterActivity<out T>(private val presenter: ContractPresenter<T>) :
    TrackingActivity() where T : ContractView {

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