package com.crosslambda.gdglifecyclebehavior

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<T, S>(protected val presenter: S) :
    AppCompatActivity() where T : ContractView, S: ContractPresenter<T> {

    override fun onStart() {
        super.onStart()

        presenter.subscribe(getView())
    }

    abstract fun getView(): T

    override fun onStop() {
        super.onStop()

        presenter.unsubscribe()
    }
}