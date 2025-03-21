package com.example.platzicalories.app.domain.tracker.use_case

import com.example.platzicalories.app.domain.tracker.model.TrackedFood
import com.example.platzicalories.app.domain.tracker.repository.TrackerRepository
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

class GetFoodsForDateUseCase(
    private val trackerRepository: TrackerRepository
) {
    operator fun invoke(date: LocalDate): Flow<List<TrackedFood>> {
        return trackerRepository.getFoodsForDate(date)
    }
}