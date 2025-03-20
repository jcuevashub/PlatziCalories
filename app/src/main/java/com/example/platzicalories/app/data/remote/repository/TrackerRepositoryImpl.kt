package com.example.platzicalories.app.data.remote.repository

import com.example.platzicalories.app.data.local.dao.TrackerDao
import com.example.platzicalories.app.data.local.mapper.toTrackedFoodEntity
import com.example.platzicalories.app.data.remote.api.OpenFoodApi
import com.example.platzicalories.app.data.remote.mapper.toTrackableFood
import com.example.platzicalories.app.domain.tracker.model.TrackableFood
import com.example.platzicalories.app.domain.tracker.model.TrackedFood
import com.example.platzicalories.app.domain.tracker.repository.TrackerRepository

class TrackerRepositoryImpl(
    private val api: OpenFoodApi,
    private val dao: TrackerDao
) : TrackerRepository {
    override suspend fun searchFood(
        query: String,
        page: Int,
        pageSize: Int
    ): Result<List<TrackableFood>> {
        return try {
            val searchDto = api.searchFood(
                query = query,
                page = page,
                pageSize = pageSize
            )
            Result.success(
                searchDto.products
                    .filter {
                        val calculatedCalories =
                            (it.nutriments.carbohydrates100g?.times(4f) ?: 0.0) +
                                    (it.nutriments.proteins100g?.times(4f) ?: 0.0) +
                                    (it.nutriments.fat100g?.times(9f) ?: 0.0)
                        val lowerBound = calculatedCalories * 0.99f
                        val upperBound = calculatedCalories * 1.01f
                        if (it.nutriments.energyKcal100g == null) {
                            0.0 in (lowerBound..upperBound)
                        } else {
                            it.nutriments.energyKcal100g in (lowerBound..upperBound)
                        }

                    }
                    .mapNotNull { it.toTrackableFood() }
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }

    override suspend fun insertTrackedFood(food: TrackedFood) {
        dao.insertTrackedFood(food.toTrackedFoodEntity())
    }
}