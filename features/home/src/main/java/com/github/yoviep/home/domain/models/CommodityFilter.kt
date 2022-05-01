package com.github.yoviep.home.domain.models


/**
 * @created 01-05-2022 15:15
 * @author yoviekaputra
 * @project eFishery
 **/

data class CommodityFilter(
    val sortBy: Sorting? = null,
    val filterByArea: String? = null,
    val name: String? = null
)

sealed class Sorting {
    object LowestPrice: Sorting()
    object HighestPrice : Sorting()
    object LowestSize: Sorting()
    object HighestSize : Sorting()
}