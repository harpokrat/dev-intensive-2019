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
    val diff = date.time - this.time

    var result = ""

    return  if (diff >= 0) {
         when (diff) {
            in 0..1*SECOND + 20 -> "только что"
            in 1*SECOND..45*SECOND -> "несколько секунд назад"
            in 45*SECOND..75*SECOND -> "минуту назад"
            in 75*SECOND..45*MINUTE -> "${TimeUnits.MINUTE.plural((diff / MINUTE).toInt())} назад"
            in 45*MINUTE..75*MINUTE -> "час назад"
            in 75*MINUTE..22*HOUR -> "${TimeUnits.HOUR.plural((diff / HOUR).toInt())} назад"
            in 22*HOUR..26*HOUR -> "день назад"
            in 26*HOUR..360*DAY -> "${TimeUnits.DAY.plural((diff / DAY).toInt())} назад"
            else -> "более года назад"
        }
    } else {
        when (-diff) {
            in 0..1 * SECOND + 20 -> "сейчас"
            in 1 * SECOND..45 * SECOND -> "через несколько секунд"
            in 45 * SECOND..75 * SECOND -> "через минуту"
            in 75 * SECOND..45 * MINUTE -> "через ${TimeUnits.MINUTE.plural((-diff / MINUTE).toInt())}"
            in 45 * MINUTE..75 * MINUTE -> "через час"
            in 75 * MINUTE..22 * HOUR -> "через ${TimeUnits.HOUR.plural((-diff / HOUR).toInt())}"
            in 22 * HOUR..26 * HOUR -> "через день"
            in 26 * HOUR..360 * DAY -> "через ${TimeUnits.DAY.plural((-diff / DAY).toInt())}"
            else -> "более чем через год"
        }
    }
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
