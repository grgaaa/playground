package com.gregor.playground.di

import com.gregor.playground.repository.PoiRepository
import com.gregor.playground.repository.PoiRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class PoiRepositoryModule {

    @Binds
    abstract fun providePoiRepository(poiRepositoryImpl: PoiRepositoryImpl): PoiRepository
}