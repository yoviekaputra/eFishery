package com.github.yoviep.abstractions.extensions

import java.text.NumberFormat
import java.util.*


/**
 * @created 01-05-2022 22:54
 * @author yoviekaputra
 * @project eFishery
 **/

fun String?.toFormatRp(): String = if (isNullOrBlank()) {
    "Rp0"
} else {
    val localeID = Locale("in", "ID")
    NumberFormat.getInstance(localeID)
        .run {
            "Rp${format(toDouble())}"
        }
}

fun String?.orZero() = if (isNullOrBlank()) {
    "0"
} else {
    toDouble()
}