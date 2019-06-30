package com.louis.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import com.louis.data.database.drama.DramaDatabase
import com.louis.data.database.drama.model.CacheDrama
import com.louis.data.database.drama.model.Sort
import junit.framework.Assert.assertTrue
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class CacheDramaDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var dramaDatabase: DramaDatabase
    @Before
    fun iniDB() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext

        dramaDatabase =
            Room.inMemoryDatabaseBuilder(context, DramaDatabase::class.java).build()

    }

    @After
    fun closeDB() {
        dramaDatabase.close()
    }

    @Test
    fun tesInsertDrama() {
        val cacheDrama = CacheDrama(
            dramaId = 333,
            dramaName = "測試",
            createdAt = 0,
            thumbUrl = "",
            rating = 5.5,
            totalViews = 4
        )
        dramaDatabase.cacheDramaDao().insert(cacheDrama)
        val cacheDramas = dramaDatabase.cacheDramaDao().getCacheDramasByIds(333)
        assertTrue(cacheDramas.first().dramaName == "測試")
    }

    @Test
    fun tesQueryDrama() {
        val data = listOf(
            CacheDrama(
                dramaId = 1,
                dramaName = "測試1",
                createdAt = 0,
                thumbUrl = "",
                rating = 5.5,
                totalViews = 8
            ),
            CacheDrama(
                dramaId = 2,
                dramaName = "測試2",
                createdAt = 0,
                thumbUrl = "",
                rating = 5.5,
                totalViews = 20
            ),
            CacheDrama(
                dramaId = 3,
                dramaName = "測試3",
                createdAt = 0,
                thumbUrl = "",
                rating = 5.5,
                totalViews = 50
            ),
            CacheDrama(
                dramaId = 4,
                dramaName = "測試4",
                createdAt = 0,
                thumbUrl = "",
                rating = 5.5,
                totalViews = 3
            )
        )
        dramaDatabase.cacheDramaDao().insertAll(data)
        val cacheDramas = dramaDatabase.cacheDramaDao().fetchDramas(Sort(CacheDrama.VIEW_COUNT, false))
        assertTrue(cacheDramas[0].dramaName == "測試3")
        assertTrue(cacheDramas[1].dramaName == "測試2")
        assertTrue(cacheDramas[2].dramaName == "測試1")
        assertTrue(cacheDramas[3].dramaName == "測試4")
    }


}