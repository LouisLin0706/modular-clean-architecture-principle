package com.louis.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import com.louis.data.database.drama.DramaDatabase
import com.louis.data.database.drama.model.CacheDrama
import junit.framework.Assert.assertTrue
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

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
            createdAt = Date(),
            thumbUrl = "",
            rating = 5.5,
            totalViews = 4
        )
        dramaDatabase.cacheDramaDao().insert(cacheDrama)
        val cacheDramas = dramaDatabase.cacheDramaDao().getCacheDramasByIds(333)
        assertTrue(cacheDramas.first().dramaName == "測試")
    }


}