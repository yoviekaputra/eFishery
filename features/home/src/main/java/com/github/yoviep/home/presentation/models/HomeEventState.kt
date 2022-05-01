package com.github.yoviep.home.presentation.models

import com.github.yoviep.home.presentation.ui.dialog.sorting.SortingUiModel


/**
 * @created 02-05-2022 00:16
 * @author yoviekaputra
 * @project eFishery
 **/

sealed class HomeEventState {
    object OnSortingClick : HomeEventState()
    data class OnSortingClicked(val sort: SortingUiModel) : HomeEventState()
}