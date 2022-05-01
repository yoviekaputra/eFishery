package com.github.yoviep.home.presentation.ui.dialog.sorting

import android.content.Context
import com.github.yoviep.home.R
import com.github.yoviep.home.domain.models.Sorting


/**
 * @created 01-05-2022 23:54
 * @author yoviekaputra
 * @project eFishery
 **/

data class SortingUiModel(
    val text: String,
    val key: Sorting? = null,
) {

    companion object {
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
    }

}