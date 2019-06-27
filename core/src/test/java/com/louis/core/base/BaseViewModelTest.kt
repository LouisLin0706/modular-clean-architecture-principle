package com.louis.core.base

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.louis.core.CoroutinesMainDispatcherRule
import com.louis.core.provideFakeCoroutinesDispatcherProvider
import org.junit.Rule
import org.junit.rules.TestRule

open class BaseViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutinesMainDispatcherRule = CoroutinesMainDispatcherRule()

    val coroutinesDispatcherProvider = provideFakeCoroutinesDispatcherProvider()

}