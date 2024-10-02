package com.example.rememberall.ui.image

import androidx.compose.runtime.mutableStateOf
import com.example.rememberall.R
import com.example.rememberall.ui.base.BaseViewModel
import com.example.rememberall.ui.base.StringProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ImageViewModel @Inject constructor(stringProvider: StringProvider): BaseViewModel() {

    val title = mutableStateOf(stringProvider.getString(R.string.image_title) ?: "" )

}