package com.louis.core.common.extension

fun Int.formatDollar(): String {
    return String.format("$ %,d", this)
}