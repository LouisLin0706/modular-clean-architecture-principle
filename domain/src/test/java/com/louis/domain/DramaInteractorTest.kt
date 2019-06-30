package com.louis.domain

import com.louis.data.database.drama.model.CacheDrama
import com.louis.data.repository.DramaRepoProtocol
import com.louis.domain.interactor.drama.DramaInteractor
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test
import java.util.*

class DramaInteractorTest {

    val mockDramasRepo = mockk<DramaRepoProtocol>()
    val dramasInteractor = DramaInteractor(mockDramasRepo)

    @Test
    fun testDramasTransform() = runBlocking {
        coEvery {
            mockDramasRepo.fetchDrama()
        } returns listOf(
            CacheDrama(
                dramaName = "測試",
                dramaId = 1,
                createdAt = Date().time,
                totalViews = 1,
                rating = 5.5,
                thumbUrl = "test"
            )
        )

        val data = dramasInteractor.fetchCacheDramas()
        coVerify(exactly = 1) { mockDramasRepo.fetchDrama() }
        assert(data.size == 1) {
            "Validate data size error"
        }
        assert(data.first().dramaName == "測試") {
            "Validate data dramaName error"
        }
    }

}