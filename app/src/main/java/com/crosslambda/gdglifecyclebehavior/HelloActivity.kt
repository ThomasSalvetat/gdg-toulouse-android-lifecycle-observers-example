package com.crosslambda.gdglifecyclebehavior

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_hello.*

class HelloActivity : BaseActivity(),
    HelloContractView,
    CustomHeaderBehavior.Contract,
    TrackingBehavior.Contract,
    PresenterBehavior.Contract<HelloContractView> {

    private val customHeaderBehavior by lazy { CustomHeaderBehavior(this, this) }
    private val presenterBehavior by lazy { PresenterBehavior(HelloPresenter(), this) }
    private val trackingBehavior by lazy { TrackingBehavior(this) }

    override fun getView(): HelloContractView = this
    override fun getCustomTitle(): Int = R.string.custom_title
    override fun getLayout(): Int = R.layout.activity_hello
    override fun getName(): String = "Hello"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        textView.setOnClickListener { presenterBehavior.presenter.getMessage() }

        // Subscribe observer to lifecycle
        lifecycle.addObserver(presenterBehavior)
        lifecycle.addObserver(trackingBehavior)
        lifecycle.addObserver(customHeaderBehavior)
    }

    override fun showMessage(message: String) {
        textView.text = message
    }
}
