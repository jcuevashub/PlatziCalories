package com.example.platzicalories.core.domain.tracker.di

import com.example.platzicalories.core.domain.tracker.repository.TrackerRepository
import com.example.platzicalories.core.domain.tracker.usecase.SearchFoodUseCase
import com.example.platzicalories.core.domain.tracker.usecase.TrackerUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object TrackerDomainModule {

    @ViewModelScoped
    @Provides
    fun provideTrackerUseCase(
        trackerRepository: TrackerRepository
    ): TrackerUseCases {
        return TrackerUseCases(searchFoodUseCase = SearchFoodUseCase(trackerRepository))
    }
}