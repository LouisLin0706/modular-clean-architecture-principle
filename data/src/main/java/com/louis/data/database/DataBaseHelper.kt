package com.louis.data.database


abstract class DbSort(val column: String, val asc: Boolean = true) {
    fun toQueryString(): String {
        return String.format("%s %s", column, if (asc) "ASC" else "DESC")
    }
}

abstract class DbQuery(
    private val column: String,
    private val operation: Operation,
    private val raw: String,
    val conditionOperation: ConditionOperation = ConditionOperation.NONE
) {
    fun toQueryString(): String {
        return java.lang.StringBuilder()
            .append(column)
            .append(" ")
            .append(operation.value)
            .append(" ")
            .append("'%' ||")
            .append(" ")
            .append(raw)
            .append(" ")
            .append("|| '%'")
            .toString()
    }
}

enum class ConditionOperation(val value: String) {
    NONE(""), AND("AND"), OR("OR")
}

enum class Operation(val value: String) {
    LIKE("LIKE"), EQUALS("=")
}

fun List<DbSort>.composeSortString(): String {
    val builder = StringBuilder()
    forEachIndexed { index, data ->
        builder.append(" ORDER BY ${data.toQueryString()}")
        if (index != size - 1) builder.append(",")
    }
    return builder.toString()
}

fun List<DbQuery>.composeWhereString(): String {
    val builder = StringBuilder()
    val iterator = iterator()
    builder.append(if (iterator.hasNext()) " WHERE " else " ")
    while (iterator.hasNext()) {
        val next = iterator.next()
        builder.append(next.toQueryString())
        if (iterator.hasNext()) {
            builder.append(" ")
            builder.append(if (iterator.hasNext()) next.conditionOperation else "")
            builder.append(" ")
        }
    }
    return builder.toString()
}