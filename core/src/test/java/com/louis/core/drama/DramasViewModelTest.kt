package com.louis.core.drama

import com.louis.core.base.BaseViewModelTest
import com.louis.core.presentation.dramas.DramasViewModel
import com.louis.domain.interactor.drama.DramaInteractorPrtocol
import com.louis.domain.model.Drama
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.*


class DramasViewModelTest  : BaseViewModelTest() {

    val dramasInteractor = mockk<DramaInteractorPrtocol>()

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
}