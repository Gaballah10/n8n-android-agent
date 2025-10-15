package com.example.realstatechatagentn8n.util

import android.text.format.DateUtils
import java.text.SimpleDateFormat
import java.util.*

object TimestampFormatter {

    private val timeFormat = SimpleDateFormat("h:mm a", Locale.getDefault())

    fun formatTimestamp(timestamp: Long): String {
        val now = System.currentTimeMillis()
        val isToday = DateUtils.isToday(timestamp)

        val timePart = timeFormat.format(Date(timestamp))

        return if (isToday) {
            "TODAY, $timePart"
        } else {
            // Optionally: "YESTERDAY, 7:43 PM" or full date
            val datePart = SimpleDateFormat("MMM d", Locale.getDefault()).format(Date(timestamp))
            "$datePart, $timePart"
        }
    }
}