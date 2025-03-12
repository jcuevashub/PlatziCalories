package com.example.platzicalories.domain.tracker.repository

import androidx.compose.foundation.pager.PageSize
import com.example.platzicalories.domain.tracker.model.TrackableFood
import retrofit2.http.Query

interface TrackerRepository {

    suspend fun searchFood(
        query: String,
        page: Int,
        pageSize: Int
    ): Result<List<TrackableFood>>
}