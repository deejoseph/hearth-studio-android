package com.dee.android.feature_home.ui

import com.dee.android.core.base.BaseViewModel
import com.dee.android.core.network.NetworkResult
import com.dee.android.core.network.RetrofitClient
import com.dee.android.core.network.safeApiCall
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class HomeViewModel : BaseViewModel() {

    private val _uiState = MutableStateFlow<NetworkResult<String>?>(null)
    val uiState: StateFlow<NetworkResult<String>?> = _uiState

    fun loadData() {
        viewModelScope.launch {
            _uiState.value = safeApiCall {
                RetrofitClient.api.test()
            }
        }
    }
}
