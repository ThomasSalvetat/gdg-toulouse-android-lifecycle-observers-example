package com.crosslambda.gdglifecyclebehavior

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<out T>(private val presenter: ContractPresenter<T>) :
    AppCompatActivity() where T : ContractView {

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