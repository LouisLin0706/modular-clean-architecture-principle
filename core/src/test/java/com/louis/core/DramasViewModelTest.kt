package com.louis.core

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.louis.core.data.model.CoroutinesDispatcherProvider
import com.louis.core.presentation.dramas.DramasViewModel
import com.louis.domain.interactor.drama.DramaInteractorPrtocol
import com.louis.domain.model.Drama
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import java.util.*


class DramasViewModelTest {

    val dramasInteractor = mockk<DramaInteractorPrtocol>()

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutinesMainDispatcherRule = CoroutinesMainDispatcherRule()

    val coroutinesDispatcherProvider = provideFakeCoroutinesDispatcherProvider()

    private lateinit var viewModel: DramasViewModel

    @Before
    fun setUp() {
        viewModel = DramasViewModel(dramasInteractor, coroutinesDispatcherProvider)
    }

    @Test
    fun loadInitialPage() {
        coEvery {
            dramasInteractor.getDramas()
        } returns listOf(
            Drama(
                dramaId = 0,
                dramaName = "測試",
                createdAt = Date(),
                thumbUrl = "",
                rating = 5.5,
                totalViews = 4
            )
        )
        System.out.println("test13" + Thread.currentThread().name)
        viewModel.fetchDramas()
        coVerify(exactly = 1) { dramasInteractor.getDramas() }
        val data = viewModel.dramas.value!!
        Assert.assertEquals(1, data.size)
    }



    fun provideFakeCoroutinesDispatcherProvider(): CoroutinesDispatcherProvider =
        CoroutinesDispatcherProvider(Dispatchers.Main, Dispatchers.Main, Dispatchers.Main)
}