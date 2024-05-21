package com.example.rememberall.ui.note

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.*
import com.example.rememberall.R
import com.example.rememberall.ui.base.StringProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NoteDetailViewModel @Inject constructor(private val provider: StringProvider): ViewModel() {
    val title: MutableLiveData<String> = MutableLiveData(provider.getString(R.string.note_detail_title))
    val text = mutableStateOf("")
}