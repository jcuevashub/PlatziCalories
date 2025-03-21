package com.example.platzicalories.app.domain.tracker.repository

import com.example.platzicalories.app.domain.tracker.model.TrackableFood
import com.example.platzicalories.app.domain.tracker.model.TrackedFood
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

interface TrackerRepository {

    suspend fun searchFood(
        query: String,
        page: Int,
        pageSize: Int
    ): Result<List<TrackableFood>>

    suspend fun insertTrackedFood(food: TrackedFood)
    fun getFoodsForDate(localDate: LocalDate): Flow<List<TrackedFood>>
}