package com.dee.android.feature_about.data

import com.dee.android.core.base.BaseViewModel
import com.dee.android.core.base.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AboutViewModel : BaseViewModel() {

    private val repository = AboutRepository()

    private val _uiState =
        MutableStateFlow<UiState<String>>(UiState.Loading)

    val uiState: StateFlow<UiState<String>> = _uiState

    fun loadData() {
        launchWithUiState(_uiState) {
            repository.loadAboutInfo()
        }
    }
}
