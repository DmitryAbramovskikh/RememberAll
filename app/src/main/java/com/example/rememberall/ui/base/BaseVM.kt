package com.example.rememberall.ui.base

import androidx.annotation.StringRes
import java.lang.ref.WeakReference

open class BaseVM(private val _parent: BaseViewModel?) {
    val parent = WeakReference(_parent)

    fun getString(@StringRes id: Int) = parent.get()?.stringProvider?.getString(id) ?: ""
}