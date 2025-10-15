package com.example.data.util

import com.example.domain.util.DispatchersProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.MainCoroutineDispatcher

class DispatchersProviderImpl(
    override val io: CoroutineDispatcher,
    override val main: MainCoroutineDispatcher,
    override val default: CoroutineDispatcher
) : DispatchersProvider