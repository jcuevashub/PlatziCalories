package com.example.platzicalories.core.domain.model


sealed class ActivityLevel(val name: String) {
    data object Low: ActivityLevel("low")
    data object Medium: ActivityLevel("medium")
    data object High: ActivityLevel("high")

    companion object {
        fun fromString(name: String): ActivityLevel {
            return when(name) {
                "low" -> Low
                "medium" -> Medium
                "high" -> High
                else -> Medium
            }
        }
    }
}
