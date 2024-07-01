package com.tsanaativa.newsapp.utils

import com.tsanaativa.newsapp.constants.Constant
import java.time.LocalDate
import java.time.format.DateTimeFormatter

object Formatter {
     fun formatDate(timestamp: String): String {
         if (timestamp == "")
             return timestamp

         val dateStr = timestamp.slice(0..9)
         val slicedDateStr = dateStr.split("-")
         val year = slicedDateStr[0].toInt()
         val monthInt = slicedDateStr[1].toInt()
         val month = Constant.MONTH_LIST[monthInt - 1]
         val day = slicedDateStr[2].toInt()
         return "$month $day, $year"
    }
}