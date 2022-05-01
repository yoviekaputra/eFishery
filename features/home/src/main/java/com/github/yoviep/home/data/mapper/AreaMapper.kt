package com.github.yoviep.home.data.mapper

import com.github.yoviep.database.entity.AreaEntity
import com.github.yoviep.home.domain.models.Area


/**
 * @created 01-05-2022 17:39
 * @author yoviekaputra
 * @project eFishery
 **/

fun AreaEntity.asDomain() = Area(
    province, city
)

fun List<AreaEntity>.asDomain() = map {
    it.asDomain()
}