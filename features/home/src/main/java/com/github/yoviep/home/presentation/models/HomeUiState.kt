package com.github.yoviep.home.presentation.models

import android.content.Context
import com.github.yoviep.home.R
import com.github.yoviep.home.domain.models.Area
import com.github.yoviep.home.domain.models.Commodity
import com.github.yoviep.home.domain.models.Sorting
import com.github.yoviep.home.presentation.ui.dialog.sorting.SortingUiModel


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

    private val areas: List<Area> = emptyList(),
    val filterByArea: Area? = null,
    val sortBy: SortingUiModel? = null
) {

    fun getSortingList(context: Context): List<SortingUiModel> {
        val sortList: MutableList<SortingUiModel> = mutableListOf()

        var sort = SortingUiModel(
            text = context.getString(R.string.sorting_default),
            key = null
        )
        sortList.add(sort)

        sort = SortingUiModel(
            text = context.getString(R.string.sorting_lowest_price),
            key = Sorting.LowestPrice
        )
        sortList.add(sort)

        sort = SortingUiModel(
            text = context.getString(R.string.sorting_highest_price),
            key = Sorting.HighestPrice
        )
        sortList.add(sort)

        sort = SortingUiModel(
            text = context.getString(R.string.sorting_lowest_size),
            key = Sorting.LowestSize
        )
        sortList.add(sort)

        sort = SortingUiModel(
            text = context.getString(R.string.sorting_highest_size),
            key = Sorting.HighestSize
        )
        sortList.add(sort)

        return sortList
    }

    fun getAreas(): List<Area> {
        val uiArea = mutableListOf<Area>()

        uiArea.add(Area("Semua", ""))
        uiArea.addAll(areas)

        return uiArea
    }
}