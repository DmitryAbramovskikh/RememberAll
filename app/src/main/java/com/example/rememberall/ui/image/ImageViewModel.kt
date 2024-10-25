package com.example.rememberall.ui.image

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.rememberall.R
import com.example.rememberall.ui.base.BaseViewModel
import com.example.rememberall.ui.base.StringProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ImageViewModel @Inject constructor(stringProvider: StringProvider): BaseViewModel() {

    override fun getTitle(): MutableState<String> = mutableStateOf("Картинка")

}