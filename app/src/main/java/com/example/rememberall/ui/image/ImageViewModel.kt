package com.example.rememberall.ui.image

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.rememberall.R
import com.example.rememberall.ui.base.BaseViewModel
import com.example.rememberall.ui.base.StringProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ImageViewModel @Inject constructor(): ViewModel() {

    fun getTitle(): MutableState<String> = mutableStateOf("Картинка")

}