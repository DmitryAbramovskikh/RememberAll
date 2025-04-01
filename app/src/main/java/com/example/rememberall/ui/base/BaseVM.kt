package com.example.rememberall.ui.base

import androidx.annotation.StringRes
import java.lang.ref.WeakReference

open class BaseVM(parent: BaseViewModel<*,*,*>?) {

    val parent = WeakReference(parent)
    fun getString(@StringRes id: Int) = parent.get()?.stringProvider?.getString(id) ?: ""

}