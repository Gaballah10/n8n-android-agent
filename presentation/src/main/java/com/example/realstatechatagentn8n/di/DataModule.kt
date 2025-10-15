package com.example.realstatechatagentn8n.di

import android.content.Context
import com.example.data.api.AgentApi
import com.example.data.repository.AgentDataSourceRepository
import com.example.data.repository.AgentDataSourceRepositoryImpl
import com.example.data.repository.DataSourceRepoImpl
import com.example.data.util.NetworkMonitorImpl
import com.example.domain.repository.DataSourceRepo
import com.example.domain.util.NetworkMonitor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideAgentDataSource(agentApi: AgentApi): AgentDataSourceRepository.Remote =
        AgentDataSourceRepositoryImpl(agentApi)

    @Provides
    @Singleton
    fun provideDataSource(agentDataSourceRepository: AgentDataSourceRepository.Remote): DataSourceRepo.Remote =
        DataSourceRepoImpl(agentDataSourceRepository)

    @Provides
    fun provideNetworkMonitor(
        @ApplicationContext context: Context
    ): NetworkMonitor = NetworkMonitorImpl(context)

}