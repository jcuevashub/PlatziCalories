package com.example.platzicalories.core.domain.tracker.repository

import com.example.platzicalories.core.domain.tracker.model.TrackableFood

interface TrackerRepository {

    suspend fun searchFood(
        query: String,
        page: Int,
        pageSize: Int
    ): Result<List<TrackableFood>>
}