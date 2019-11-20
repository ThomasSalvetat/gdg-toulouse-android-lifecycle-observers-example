package com.crosslambda.gdglifecyclebehavior

import android.os.Bundle
import android.widget.Toast
import com.crosslambda.gdglifecyclebehavior.behavior.Behavior
import com.crosslambda.gdglifecyclebehavior.behavior.behaviorFactory
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_hello.*
import java.util.concurrent.TimeUnit

class HelloActivity : BaseActivity(),
    HelloContractView,
    CustomHeaderBehavior.Contract,
    TrackingBehavior.Contract,
    PresenterBehavior.Contract<HelloContractView>,
    ReactiveBehavior.Contract {

    @Behavior
    private val customHeaderBehavior by behaviorFactory { CustomHeaderBehavior(this, this) }

    @Behavior
    private val presenterBehavior by behaviorFactory { PresenterBehavior(HelloPresenter(), this) }

    @Behavior
    private val trackingBehavior by behaviorFactory { TrackingBehavior(this) }

    @Behavior
    private val reactiveBehavior by behaviorFactory { ReactiveBehavior(this) }

    override fun getView(): HelloContractView = this
    override fun getCustomTitle(): Int = R.string.custom_title
    override fun getLayout(): Int = R.layout.activity_hello
    override fun getName(): String = "Hello"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        textView.setOnClickListener { presenterBehavior.presenter.getMessage() }
    }

    override fun startObserve(compositeDisposable: CompositeDisposable) {
        Observable.timer(5, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { Toast.makeText(this, "Timer finished !", Toast.LENGTH_LONG).show() }
            .let(compositeDisposable::add)
    }

    override fun showMessage(message: String) {
        textView.text = message
    }
}
