package com.crosslambda.gdglifecyclebehavior

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_hello.*

class HelloActivity : BaseActivity(),
    HelloContractView,
    CustomHeaderBehavior.Contract,
    TrackingBehavior.Contract,
    PresenterBehavior.Contract<HelloContractView> {

    private val customHeaderBehavior by lazy { CustomHeaderBehavior(this) }
    private val presenterBehavior by lazy { PresenterBehavior(HelloPresenter(), this) }
    private val trackingBehavior by lazy { TrackingBehavior(this) }

    override fun getView(): HelloContractView = this
    override fun getCustomTitle(): Int = R.string.custom_title
    override fun getLayout(): Int = R.layout.activity_hello
    override fun getName(): String = "Hello"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        textView.setOnClickListener { presenterBehavior.presenter.getMessage() }
        customHeaderBehavior.onCreate(this)
        trackingBehavior.onCreate()
    }

    override fun onStart() {
        super.onStart()
        presenterBehavior.onStart()
    }

    override fun onStop() {
        super.onStop()
        presenterBehavior.onStop()
    }

    override fun showMessage(message: String) {
        textView.text = message
    }
}
