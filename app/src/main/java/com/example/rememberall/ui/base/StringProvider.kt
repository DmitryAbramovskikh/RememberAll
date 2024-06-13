package com.example.rememberall.ui.base

import androidx.annotation.StringRes

interface StringProvider
{
    fun getString(@StringRes id: Int): String
}