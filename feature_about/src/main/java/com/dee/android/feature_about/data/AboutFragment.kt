package com.dee.android.feature_about.data

import android.os.Bundle
import android.util.Log
import android.view.View
import com.dee.android.core.base.BaseFragment
import com.dee.android.feature_about.R
import androidx.fragment.app.viewModels


class AboutFragment :
    BaseFragment<AboutViewModel, String>(R.layout.fragment_about) {

    override val viewModel: AboutViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeState(viewModel.uiState)
        viewModel.loadData()
    }

    override fun onLoading() {
        Log.d("AboutFragment", "Loading...")
    }

    override fun onSuccess(data: String?) {
        Log.d("AboutFragment", "Success: $data")
    }

    override fun onError(message: String?) {
        Log.e("AboutFragment", "Error: $message")
    }

    override fun onEmpty() {
        Log.d("AboutFragment", "Empty")
    }
}
