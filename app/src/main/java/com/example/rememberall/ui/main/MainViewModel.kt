package com.example.rememberall.ui.main

import com.example.rememberall.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(): BaseViewModel<MainContract.State, MainContract.Intent, MainContract.Effect>() {

    override suspend fun dispatchIntent(intent: MainContract.Intent) {
        when(intent)
        {
            else -> {}
        }
    }

    override fun setInitState(): MainContract.State = MainContract.State(isLoading = false)

}