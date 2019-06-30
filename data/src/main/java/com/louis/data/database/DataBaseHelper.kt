package com.louis.data.database


abstract class DbSort(val column: String, val asc: Boolean = true) {
    fun toQueryString(): String {
        return String.format("%s %s", column, if (asc) "ASC" else "DESC")
    }
}

// 組 SQL order condition
fun List<DbSort>.composeSortString(): String {
    val builder = StringBuilder()
    forEachIndexed { index, data ->
        builder.append(" ORDER BY ${data.toQueryString()}")
        if (index != size - 1) builder.append(",")
    }
    return builder.toString()
}

// 組 SQL where condition
fun List<String>.composeWhereString(): String {
    val builder = StringBuilder()
    val iterator = iterator()
    builder.append(if (iterator.hasNext()) " WHERE " else " ")
    while (iterator.hasNext()) {
        builder.append(iterator.next())
        builder.append(if (iterator.hasNext()) " AND " else " ")
    }
    return builder.toString()
}