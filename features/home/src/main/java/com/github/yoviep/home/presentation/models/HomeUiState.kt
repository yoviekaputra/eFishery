package com.github.yoviep.home.presentation.models

import com.github.yoviep.home.domain.models.Commodity
import com.github.yoviep.home.domain.models.Sorting


/**
 * @created 01-05-2022 22:41
 * @author yoviekaputra
 * @project eFishery
 **/

data class HomeUiState(
    val isLoading: Boolean = true,
    val items: List<Commodity> = emptyList(),
    val errorMessage: String = "",
    val showSortDialog: Boolean = false,
    val showFilterDialog: Boolean = false,

    val filterByArea: String? = null,
    val sortBy: Sorting? = null
)