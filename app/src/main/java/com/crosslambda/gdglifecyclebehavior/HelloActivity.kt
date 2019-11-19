package com.crosslambda.gdglifecyclebehavior

import android.os.Bundle
import com.crosslambda.gdglifecyclebehavior.behavior.*
import kotlinx.android.synthetic.main.activity_hello.*

class HelloActivity : BaseActivity(),
    HelloContractView,
    CustomHeaderBehavior.Contract,
    TrackingBehavior.Contract,
    PresenterBehavior.Contract<HelloContractView> {

    @Behavior
    private val customHeaderBehavior by behaviorFactory { CustomHeaderBehavior(this, this) }

    @Behavior
    private val presenterBehavior by behaviorFactory { PresenterBehavior(HelloPresenter(), this) }

    @Behavior
    private val trackingBehavior by behaviorFactory { TrackingBehavior(this) }

    override fun getView(): HelloContractView = this
    override fun getCustomTitle(): Int = R.string.custom_title
    override fun getLayout(): Int = R.layout.activity_hello
    override fun getName(): String = "Hello"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        textView.setOnClickListener { presenterBehavior.presenter.getMessage() }
    }

    override fun showMessage(message: String) {
        textView.text = message
    }
}
