package com.crosslambda.gdglifecyclebehavior

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_hello.*

class HelloActivity : BaseActivity<HelloContractView, HelloPresenter>(HelloPresenter()), HelloContractView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)
        textView.setOnClickListener { presenter.getMessage() }
    }

    override fun getView(): HelloContractView = this

    override fun showMessage(message: String) {
        textView.text = message
    }

}
