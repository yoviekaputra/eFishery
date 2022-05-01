package com.github.yoviep.home.presentation.ui.dialog.sorting

import com.github.yoviep.home.domain.models.Sorting


/**
 * @created 01-05-2022 23:54
 * @author yoviekaputra
 * @project eFishery
 **/

data class SortingUiModel(
    val text: String,
    val key: Sorting? = null,
)