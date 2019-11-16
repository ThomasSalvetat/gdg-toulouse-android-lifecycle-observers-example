package com.crosslambda.gdglifecyclebehavior

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_hello.*

class HelloActivity : BaseActivity<HelloContractView, HelloPresenter>(HelloPresenter()), HelloContractView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        textView.setOnClickListener { presenter.getMessage() }
    }

    override fun getView(): HelloContractView = this
    override fun getCustomTitle(): Int = R.string.custom_title
    override fun getLayout(): Int = R.layout.activity_hello
    override fun getName(): String = "Hello"

    override fun showMessage(message: String) {
        textView.text = message
    }

}
