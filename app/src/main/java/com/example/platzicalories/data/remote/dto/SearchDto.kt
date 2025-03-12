package com.example.platzicalories.data.remote.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchDto(
    val products: List<Product>
)
