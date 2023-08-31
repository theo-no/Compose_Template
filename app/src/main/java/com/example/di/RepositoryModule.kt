package com.example.di

import com.example.data.repository.GitHubRepositoryImpl
import com.example.data.service.GitHubService
import com.example.domain.repository.GitHubRepository
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
    fun provideGitHubRepository(GitHubService: GitHubService): GitHubRepository{
        return GitHubRepositoryImpl(GitHubService)
    }
}