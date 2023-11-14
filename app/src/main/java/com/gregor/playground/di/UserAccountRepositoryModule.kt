package com.gregor.playground.di

import com.gregor.playground.repository.UserAccountRepository
import com.gregor.playground.repository.UserAccountRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class UserAccountRepositoryModule {

    @Binds
    abstract fun providePoiRepository(userAccountRepositoryImpl: UserAccountRepositoryImpl): UserAccountRepository
}