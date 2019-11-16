package com.crosslambda.gdglifecyclebehavior

interface ContractPresenter<T> where T : ContractView {
    val view: T?
    fun subscribe(view: T)
    fun unsubscribe()
}