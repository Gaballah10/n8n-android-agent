@file:Suppress("InjectDispatcher")

package com.example.realstatechatagentn8n.di

import com.example.data.util.DispatchersProviderImpl
import com.example.domain.util.DispatchersProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainCoroutineDispatcher

@Module
@InstallIn(SingletonComponent::class)
class DispatcherModule {

    @Provides
    @IoDispatcher
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @DefaultDispatcher
    fun providesDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @Provides
    @MainDispatcher
    fun providesMainDispatcher(): MainCoroutineDispatcher = Dispatchers.Main

    @Provides
    fun providesDispatcherProvider(
        @IoDispatcher io: CoroutineDispatcher,
        @MainDispatcher main: MainCoroutineDispatcher,
        @DefaultDispatcher default: CoroutineDispatcher
    ): DispatchersProvider {
        return DispatchersProviderImpl(
            io = io,
            main = main,
            default = default
        )
    }
}