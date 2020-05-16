package com.example.ilactakipasistanim.ui.base

import android.os.Bundle
import java.util.concurrent.atomic.AtomicBoolean

abstract class BasePresenter<T: BaseView>(protected val view: T?) {

    protected var isViewAlive = AtomicBoolean()


    open fun initialize(extras: Bundle?) {}

    open fun start() {
        isViewAlive.set(true)
    }

    open fun finalizeView() {
        isViewAlive.set(false)
    }

}