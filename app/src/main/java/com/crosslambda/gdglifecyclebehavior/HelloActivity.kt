package com.crosslambda.gdglifecyclebehavior

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_hello.*

class HelloActivity : AppCompatActivity(), HelloContractView {

    private val presenter = HelloPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)
        textView.setOnClickListener { presenter.getMessage() }
    }

    override fun onStart() {
        super.onStart()
        presenter.subscribe(this)
    }

    override fun onStop() {
        super.onStop()
        presenter.unsubscribe()
    }

    override fun showMessage(message: String) {
        textView.text = message
    }

}