package com.example.platzicalories.presentation.tracker_overview.components

import androidx.compose.runtime.Composable
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Local

@Composable
fun ParseDateText(date: LocalDate): String {
    val today = LocalDate.now()
    return when(date) {
        today -> "Today"
        today.minusDays(1) -> "Yesterday"
        today.plusDays(1) -> "Tomorrow"
        else -> DateTimeFormatter.ofPattern("dd LLLL").format(date)
    }
}