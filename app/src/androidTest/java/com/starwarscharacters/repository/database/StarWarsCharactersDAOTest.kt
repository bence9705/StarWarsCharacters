package com.starwarscharacters.repository.database

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.*
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.starwarscharacters.getOrAwaitValue
import com.starwarscharacters.repository.model.StarWarsCharactersEntity
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import kotlinx.coroutines.test.runBlockingTest
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class StarWarsCharactersDAOTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    private lateinit var database: AppDatabase
    private lateinit var dao: StarWarsCharactersDAO

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).allowMainThreadQueries()
            .build()
        dao = database.starWarsCharacterDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun insertCharacter() = runBlockingTest {
        val starWarsCharactersEntity = StarWarsCharactersEntity(
            1,
            "Yoda",
            "50",
            "30",
            "white",
            "green",
            "brown",
            "unkown",
            "male",
            "unkown",
            null,
            null,
            null
        )
        dao.insertCharacter(starWarsCharactersEntity)

        val allStarWarsCharactersEntity = dao.getAllCharactersForTest().getOrAwaitValue()

        assertThat(allStarWarsCharactersEntity.contains(starWarsCharactersEntity))
    }

    @Test
    fun deleteCharacter() = runBlockingTest {
        val starWarsCharactersEntity = StarWarsCharactersEntity(
            1,
            "Yoda",
            "50",
            "30",
            "white",
            "green",
            "brown",
            "unkown",
            "male",
            "unkown",
            null,
            null,
            null
        )
        dao.insertCharacter(starWarsCharactersEntity)
        dao.deleteCharacter(starWarsCharactersEntity)

        val allStarWarsCharactersEntity = dao.getAllCharactersForTest().getOrAwaitValue()

        assertThat(allStarWarsCharactersEntity).doesNotContain(starWarsCharactersEntity)
    }

    @Test
    fun observeAllCharacters() = runBlockingTest {
        val starWarsCharactersEntity1 = StarWarsCharactersEntity(1, "Yoda", "50", "30", "white", "green", "brown", "unkown", "male", "unkown", null, null, null)
        val starWarsCharactersEntity2 = StarWarsCharactersEntity(2, "Obi", "180", "80", "white", "green", "brown", "unkown", "male", "unkown", null, null, null)
        val starWarsCharactersEntity3 = StarWarsCharactersEntity(3, "R2D2", "80", "60", "white", "green", "brown", "unkown", "male", "unkown", null, null, null)

        dao.insertCharacter(starWarsCharactersEntity1)
        dao.insertCharacter(starWarsCharactersEntity2)
        dao.insertCharacter(starWarsCharactersEntity3)

        val allStarWarsCharactersEntity = dao.getAllCharactersForTest().getOrAwaitValue()

        assertThat(allStarWarsCharactersEntity.size).isEqualTo(3)
    }

    @Test
    fun observeCharacterDetails() = runBlockingTest {
        val starWarsCharactersEntity = StarWarsCharactersEntity(
            1,
            "Yoda",
            "50",
            "30",
            "white",
            "green",
            "brown",
            "unkown",
            "male",
            "unkown",
            null,
            null,
            null
        )
        dao.insertCharacter(starWarsCharactersEntity)

        val allStarWarsCharactersEntity = dao.getAllCharactersForTest().getOrAwaitValue()

        assertThat(allStarWarsCharactersEntity[0].name == "Yoda")
        assertThat(allStarWarsCharactersEntity[0].height == "50")
        assertThat(allStarWarsCharactersEntity[0].mass == "30")
        assertThat(allStarWarsCharactersEntity[0].hair_color == "white")
        assertThat(allStarWarsCharactersEntity[0].skin_color == "green")
        assertThat(allStarWarsCharactersEntity[0].eye_color == "brown")
        assertThat(allStarWarsCharactersEntity[0].birth_year == "unkown")
        assertThat(allStarWarsCharactersEntity[0].gender == "male")
        assertThat(allStarWarsCharactersEntity[0].homeworld == "unkown")
    }
}
