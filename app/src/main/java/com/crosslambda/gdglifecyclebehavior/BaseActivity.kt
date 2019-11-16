package com.crosslambda.gdglifecyclebehavior

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<T, S>(protected val presenter: S) :
    AppCompatActivity() where T : ContractView, S: ContractPresenter<T> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        findViewById<TextView>(R.id.header_custom_title).text = getString(getCustomTitle()) // HEADER
        TrackingService.track(getName())                                                    // TRACKING
    }

    override fun onStart() {
        super.onStart()

        presenter.subscribe(getView())                                                      // PRESENTER
    }

    abstract fun getView(): T
    abstract fun getCustomTitle(): Int
    abstract fun getLayout(): Int
    abstract fun getName(): String

    override fun onStop() {
        super.onStop()

        presenter.unsubscribe()                                                             // PRESENTER
    }
}