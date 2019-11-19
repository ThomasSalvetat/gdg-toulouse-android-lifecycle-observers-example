package com.crosslambda.gdglifecyclebehavior

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.crosslambda.gdglifecyclebehavior.behavior.BehaviorContainer
import com.crosslambda.gdglifecyclebehavior.behavior.BehaviorSubscriber
import com.crosslambda.gdglifecyclebehavior.behavior.bindContainerToLifecycle

abstract class BaseActivity :
    AppCompatActivity(), BehaviorSubscriber {

    override val behaviorContainer: BehaviorContainer by bindContainerToLifecycle()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
    }

    abstract fun getLayout(): Int
}