package com.github.yoviep.home.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.yoviep.home.domain.models.Area
import com.github.yoviep.home.domain.models.CommodityFilter
import com.github.yoviep.home.domain.usecases.AddCommodityUseCase
import com.github.yoviep.home.domain.usecases.GetAreaUseCase
import com.github.yoviep.home.domain.usecases.GetCommodityUseCase
import com.github.yoviep.home.presentation.models.HomeEventState
import com.github.yoviep.home.presentation.models.HomeUiState
import com.github.yoviep.home.presentation.ui.dialog.sorting.SortingUiModel
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
    private val getAreaUseCase: GetAreaUseCase,
    private val addCommodityUseCase: AddCommodityUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            getAreaUseCase.invoke().collect { items ->
                _uiState.update {
                    it.copy(areas = items)
                }
            }
        }
    }

    fun getCommodity() {
        viewModelScope.launch {
            getCommodityUseCase.invoke(
                filter = CommodityFilter(
                    sortBy = _uiState.value.sortBy?.key,
                    filterByArea = _uiState.value.filterByArea?.province,
                    name = _uiState.value.keyword
                ),
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

    fun onEventState(event: HomeEventState) {
        when (event) {
            is HomeEventState.OnSortingClick -> {
                onSortingClick()
            }
            is HomeEventState.OnSortingClicked -> {
                onSortingClicked(sort = event.sort)
            }
            is HomeEventState.OnFilterClick -> {
                onFilterClick()
            }
            is HomeEventState.OnFilterClicked -> {
                onFilterClicked(area = event.area)
            }
            is HomeEventState.OnSearchChanged -> {
                onSearchChanged(keyword = event.keyword)
            }
            is HomeEventState.OnSearchClear -> {
                onSearchClear()
            }
        }
    }

    private fun onSearchClear() {
        _uiState.update {
            it.copy(keyword = null)
        }
        getCommodity()
    }

    private fun onSearchChanged(keyword: String) {
        _uiState.update {
            it.copy(keyword = keyword)
        }
        getCommodity()
    }

    private fun onFilterClicked(area: Area) {
        _uiState.update {
            it.copy(
                filterByArea = if (area.province == "Semua") {
                    null
                } else {
                    area
                },
                showFilterDialog = false
            )
        }
        getCommodity()
    }

    private fun onFilterClick() {
        _uiState.update {
            it.copy(showFilterDialog = true)
        }
    }

    private fun onSortingClicked(sort: SortingUiModel) {
        _uiState.update {
            it.copy(
                sortBy = if (sort.key == null) {
                    null
                } else {
                    sort
                },
                showSortDialog = false
            )
        }
        getCommodity()
    }

    private fun onSortingClick() {
        _uiState.update {
            it.copy(showSortDialog = true)
        }
    }
}