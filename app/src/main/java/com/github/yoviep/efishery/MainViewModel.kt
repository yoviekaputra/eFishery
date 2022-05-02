package com.github.yoviep.efishery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.yoviep.home.domain.models.CommodityFilter
import com.github.yoviep.home.domain.usecases.GetCommodityUseCase
import com.github.yoviep.syncronize.domain.usecases.SyncUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * @created 03-05-2022 00:10
 * @author yoviekaputra
 * @project eFishery
 **/

@HiltViewModel
class MainViewModel @Inject constructor(
    private val syncUseCase: SyncUseCase,
    private val getCommodityUseCase: GetCommodityUseCase
) : ViewModel() {

    // local data provided
    private val _prepared = MutableLiveData<Unit>()
    val prepared: LiveData<Unit> get() = _prepared

    // local data not provided, and do sync
    private val _syncFinished = MutableLiveData<Unit>()
    val syncFinished: LiveData<Unit> get() = _syncFinished

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    fun getCommodity() = viewModelScope.launch{
        getCommodityUseCase.invoke(filter = CommodityFilter())
            .collect {
                if (it.isEmpty()) {
                    sync()
                } else {
                    _prepared.value = Unit
                }
            }
    }

    private fun sync() = viewModelScope.launch {
        runCatching {
            syncUseCase.invoke()
        }.onSuccess {
            _syncFinished.value = Unit
        }.onFailure {
            _errorMessage.value = it.message.orEmpty()
        }
    }
}