package com.example.di

import com.example.data.datasource.remote.GitHubDataSource
import com.example.data.datasource.remote.GitHubDataSourceImpl
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
object DataSourceModule {
    @Singleton
    @Provides
    fun provideGitHubRepository(gitHubService: GitHubService): GitHubDataSource {
        return GitHubDataSourceImpl(gitHubService)
    }
}