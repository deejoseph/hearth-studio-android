package com.dee.android.feature_home.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import com.dee.android.core.network.NetworkResult
import com.dee.android.feature_home.R
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.launch


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeUiState()

        viewModel.loadData()
    }


    private fun observe() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {
                    when (it) {

                        is NetworkResult.Loading -> {
                            println("Loading...")
                        }

                        is NetworkResult.Success -> {
                            println(it.data)
                        }

                        is NetworkResult.Error -> {
                            println(it.message)
                        }
                    }
                }
            }
        }
    }


    private fun observeUiState() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { result ->
                    when (result) {
                        is NetworkResult.Loading -> {
                            showLoading()
                        }

                        is NetworkResult.Success -> {
                            showContent(result.data)
                        }

                        is NetworkResult.Error -> {
                            showError(result.message)
                        }

                        null -> {
                            // 初始状态
                        }
                    }
                }
            }
        }
    }

    private fun showLoading() {
        Log.d("HomeFragment", "Loading...")
    }

    private fun showContent(data: String?) {
        Log.d("HomeFragment", "Success: $data")
    }

    private fun showError(message: String?) {
        Log.e("HomeFragment", "Error: $message")
    }


}
