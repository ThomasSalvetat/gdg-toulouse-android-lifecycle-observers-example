package com.crosslambda.gdglifecyclebehavior

class HelloPresenter : ContractPresenter<HelloContractView>, HelloContractPresenter {
    override var view: HelloContractView? = null

    override fun subscribe(v: HelloContractView) {
        view = v
        getMessage()
    }

    override fun unsubscribe() {
        view = null
    }

    override fun getMessage() {
        view?.showMessage("Hello :)")
    }
}