package com.baize.book.utils

import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.ZoneId
import java.util.*
import kotlin.jvm.JvmStatic

/**
 * @author seven
 */
object DateUtil {
    fun getFormat(date: Date?, format: String?): String {
        val sdf = SimpleDateFormat(format)
        return sdf.format(date)
    }

    fun getFormat(date: Date?): String {
        return getFormat(date, "yyyy-MM-dd HH:mm:ss")
    }

    fun getFormat(date: LocalDateTime): String {
        return getFormat(date, "yyyy-MM-dd HH:mm:ss")
    }

    fun getFormat(date: LocalDateTime, format: String?): String {
        return date.format(DateTimeFormatter.ofPattern(format))
    }

    fun getFormat(format: String?): String {
        return getFormat(Date(), format)
    }

    fun getDate(year: Int, month: Int, dayOfMonth: Int, hour: Int, minute: Int, second: Int): Date {
        val dateTime = LocalDateTime.of(year, month, dayOfMonth, hour, minute, second)
        return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant())
    }

    fun dateFormat(dateTime: LocalDateTime, format: String): String {
        val now = LocalDateTime.now()
        if (dateTime.year <= now.year && dateTime.monthValue <= now.monthValue) {
            val day = now.dayOfMonth - dateTime.dayOfMonth
            if (day <= 7 && day > -1) {
                if (day == 0) {
                    val hour = now.hour - dateTime.hour
                    if (hour == 0) {
                        val minute = now.minute - dateTime.minute
                        if (minute >= 0) {
                            if (minute == 0) {
                                val second = now.second - dateTime.second
                                return second.toString() + "秒前"
                            }
                            return minute.toString() + "分钟前"
                        }
                    } else if (hour > 0) {
                        return hour.toString() + "小时前"
                    }
                } else {
                    return day.toString() + "天前"
                }
            }
        }
        return getFormat(dateTime, format)
    }

}