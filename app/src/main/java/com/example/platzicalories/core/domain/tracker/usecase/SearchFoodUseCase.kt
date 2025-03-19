package com.example.platzicalories.core.domain.tracker.usecase

import com.example.platzicalories.core.domain.tracker.model.TrackableFood
import com.example.platzicalories.core.domain.tracker.repository.TrackerRepository

class SearchFoodUseCase(
    private val trackerRepository: TrackerRepository
) {
    suspend operator fun invoke(
        query: String,
        page: Int = 1,
        pageSize: Int = 40
    ): Result<List<TrackableFood>> {
        if (query.isBlank()) {
            return Result.success(emptyList())
        }
        return trackerRepository.searchFood(query.trim(), page, pageSize)
    }
}