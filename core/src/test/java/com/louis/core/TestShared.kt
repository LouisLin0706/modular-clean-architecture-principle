package com.louis.core

import com.louis.core.data.model.CoroutinesDispatcherProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import java.util.concurrent.Executors

class CoroutinesMainDispatcherRule : TestWatcher() {

    private val singleThreadExecutor = Executors.newSingleThreadExecutor()

    override fun starting(description: Description?) {
        super.starting(description)
        Dispatchers.setMain(singleThreadExecutor.asCoroutineDispatcher())
    }

    override fun finished(description: Description?) {
        super.finished(description)
        singleThreadExecutor.shutdownNow()
        Dispatchers.resetMain()
    }
}

fun provideFakeCoroutinesDispatcherProvider(): CoroutinesDispatcherProvider =
    CoroutinesDispatcherProvider(Dispatchers.Main, Dispatchers.Main, Dispatchers.Main)