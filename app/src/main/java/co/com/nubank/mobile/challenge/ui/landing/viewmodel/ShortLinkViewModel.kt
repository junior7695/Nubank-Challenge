package co.com.nubank.mobile.challenge.ui.landing.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.com.nubank.mobile.challenge.infrastructure.core.aplication.entities.Link
import co.com.nubank.mobile.challenge.infrastructure.core.repository.ShortLinkRepository
import co.com.nubank.mobile.challenge.infrastructure.core.converters.Result
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class ShortLinkViewModel @Inject constructor(
    private val repository: ShortLinkRepository
) : ViewModel() {

    private val tagLog = "ShortLinkViewModel: "

    private val _dataLoading = MutableLiveData<Boolean>()
    val dataLoading: LiveData<Boolean> = _dataLoading

    private val _recentlyItems =
        MutableLiveData<MutableList<Link>>().apply { value = mutableListOf() }
    val recentlyItems: LiveData<MutableList<Link>> = _recentlyItems

    fun postShortLink(url: String, errorViewListener: ErrorView) {
        _dataLoading.value = true

        viewModelScope.launch {

            repository.postShortLink(url).let { result ->

                when (result) {
                    is Result.Success -> {
                        errorViewListener.showError(false)
                        Log.d(tagLog, "Request -> Success: $result")
                        _dataLoading.value = false
                        _recentlyItems.value?.add(result.data)
                    }

                    is Result.Error -> {
                        val msg = "Request -> Error: ${result.exception.message}"
                        Log.d(tagLog, msg)
                        _dataLoading.value = false
                        errorViewListener.showError(true, msg)
                    }

                    is Result.Loading -> {
                        errorViewListener.showError(false)
                        Log.d(tagLog, "Request -> Loading...")
                        _dataLoading.value = true
                    }
                }
            }
        }
    }

    internal interface ErrorView {
        fun showError(showErrorScreen: Boolean, errorMessage: String? = null)
    }
}