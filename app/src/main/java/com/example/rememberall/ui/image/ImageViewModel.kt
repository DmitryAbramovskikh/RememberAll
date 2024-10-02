package com.example.rememberall.ui.image

import android.graphics.BitmapFactory
import androidx.compose.runtime.mutableStateOf
import com.example.rememberall.R
import com.example.rememberall.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ImageViewModel @Inject constructor(): BaseViewModel()
{
    val title = mutableStateOf(stringProvider?.getString(R.string.image_title) ?: "" )
    //val bitmap = BitmapFactory.decodeFile()
}