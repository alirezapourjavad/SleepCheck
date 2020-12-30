package com.example.sleepcheck.dataModel

import java.text.SimpleDateFormat
import java.util.Date


fun Long.formatDate(): String {
    val df = SimpleDateFormat("yyyy.MM.dd ")
    val date = Date(this)
    return df.format(date)

}

fun Long.formatTime(): String {
    val df = SimpleDateFormat("HH.mm.SS ")
    val date = Date(this)
    return df.format(date)
}
