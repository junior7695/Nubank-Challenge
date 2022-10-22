package co.com.nubank.mobile.challenge.ui.landing.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.com.nubank.mobile.challenge.infrastructure.core.repository.ShortLinkRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class ShortLinkViewModel @Inject constructor(
    private val repository: ShortLinkRepository
) : ViewModel() {

    private val tagLog = "ShortLinkViewModel: "

    private val _dataLoading = MutableLiveData<Boolean>()
    val dataLoading: LiveData<Boolean> = _dataLoading

    fun getLinkByAlias(errorViewListener: ErrorView) {
        _dataLoading.value = true

        viewModelScope.launch {

        }
    }

    internal interface ErrorView {
        fun showError(showErrorScreen: Boolean, errorMessage: String? = null)
    }
}