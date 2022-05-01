package com.github.yoviep.home.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.yoviep.home.domain.models.CommodityFilter
import com.github.yoviep.home.domain.usecases.AddCommodityUseCase
import com.github.yoviep.home.domain.usecases.GetCommodityUseCase
import com.github.yoviep.home.presentation.models.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * @created 01-05-2022 17:43
 * @author yoviekaputra
 * @project eFishery
 **/

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCommodityUseCase: GetCommodityUseCase,
    private val addCommodityUseCase: AddCommodityUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    fun getCommodity() {
        viewModelScope.launch {
            getCommodityUseCase.invoke(
                filter = CommodityFilter()
            ).onStart {
                _uiState.update {
                    it.copy(isLoading = true)
                }
            }.onCompletion {
                _uiState.update {
                    it.copy(isLoading = false)
                }
            }.catch { exception ->
                _uiState.update {
                    it.copy(errorMessage = exception.message.orEmpty())
                }
            }.collect { items ->
                _uiState.update {
                    it.copy(items = items)
                }
            }
        }
    }
}