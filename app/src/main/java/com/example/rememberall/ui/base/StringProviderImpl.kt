package com.example.rememberall.ui.base

import android.content.Context
import javax.inject.Inject

class StringProviderImpl @Inject constructor (private val context: Context): StringProvider
{
    override fun getString(id: Int): String = context.getString(id)
}