package com.example.di

import com.example.data.repository.ExampleRepositoryImpl
import com.example.data.service.ExampleService
import com.example.domain.repository.ExampleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideExampleRepository(exampleService: ExampleService): ExampleRepository{
        return ExampleRepositoryImpl(exampleService)
    }
}