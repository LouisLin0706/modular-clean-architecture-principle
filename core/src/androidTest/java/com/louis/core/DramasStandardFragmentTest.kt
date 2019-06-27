package com.louis.core

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.runner.AndroidJUnit4
import com.android21buttons.fragmenttestrule.FragmentTestRule
import com.louis.core.presentation.dramas.DramasStandardFragment
import com.louis.core.presentation.dramas.DramasViewModel
import com.louis.domain.interactor.drama.DramaInteractorPrtocol
import com.louis.domain.model.Drama
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import java.util.*

@RunWith(AndroidJUnit4::class)
class DramasStandardFragmentTest {

    @get:Rule
    val fragmentTestRule = FragmentTestRule.create(DramasStandardFragment::class.java, true, false)

    @Test
    fun load_single_item_page() {

        val dramasInteractor = mockDramasInteractor()
        configureKoin(dramasInteractor)

        launchFragment()

        onView(withText("測試")).check(matches(isDisplayed()))
    }

    private fun launchFragment() {
        val fragment = DramasStandardFragment.newInstance()
        fragmentTestRule.launchFragment(fragment)
    }

    private fun configureKoin(dramasInteractor: DramaInteractorPrtocol) {
        val dramasKoinModule = module {
            viewModel { DramasViewModel(dramasInteractor) }
        }
        startKoin {
            androidContext(mockk())
            modules(dramasKoinModule)
        }
    }


    private fun mockDramasInteractor(): DramaInteractorPrtocol {
        val dramasUseCase = mockk<DramaInteractorPrtocol>()
        every {
            runBlocking {
                dramasUseCase.getDramas()
            }
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
        return dramasUseCase
    }
}