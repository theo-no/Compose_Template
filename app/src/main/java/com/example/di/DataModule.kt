package com.example.di

import com.example.data.repository.ExampleRepositoryImpl
import com.example.domain.repository.ExampleRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    fun bindTempRepository(exampleRepositoryImpl: ExampleRepositoryImpl): ExampleRepository
}