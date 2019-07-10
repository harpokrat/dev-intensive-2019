package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern: String="HH:mm:ss dd.MM.yy"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND): Date {
    var time = this.time

    time += when (units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }
    this.time = time
    return this
}

fun Date.humanizeDiff(date:Date = Date()): String {
    // TODO: write this
    return ""
}

enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY;

    fun plural(value: Int): String {
        var suffix = ""
        when (this) {
            SECOND -> {
                suffix = if (value in 5..20) "секунд"
                else if (value % 10 == 1) "секунду"
                else if (value % 10 == 2 || value % 10 == 3 || value % 10 == 4) "секунды"
                else "секунд"
            }
            MINUTE ->
                suffix = if (value in 5..20) "минут"
                else if (value % 10 == 1) "минуту"
                else if (value % 10 == 2 || value % 10 == 3 || value % 10 == 4) "минуты"
                else "минут"
            HOUR ->
                suffix = if (value in 5..20) "часов"
                else if (value % 10 == 1) "час"
                else if (value % 10 == 2 || value % 10 == 3 || value % 10 == 4) "часа"
                else "часов"
            DAY ->
                suffix = if (value in 5..20) "дней"
                else if (value % 10 == 1) "день"
                else if (value % 10 == 2 || value % 10 == 3 || value % 10 == 4) "дня"
                else "дней"
        }

        return "$value $suffix"

    }
}
