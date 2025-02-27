package com.example.platzicalories.core.domain.model

sealed class Gender(val name: String) {
    data object Male : Gender("male")
    data object Female : Gender("female")
    data object Other: Gender("other")

    companion object {
        fun fromString(name: String): Gender {
            return when (name) {
                "male" -> Male
                "female" -> Female
                "other" -> Other
                else -> Male
            }
        }
    }
}