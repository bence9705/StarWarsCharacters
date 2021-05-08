package com.starwarscharacters.repository.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.starwarscharacters.repository.model.StarWarsCharactersEntity

@Dao
interface StarWarsCharactersDAO {
    @Query("SELECT * FROM characters")
    fun getAllCharacters(): List<StarWarsCharactersEntity>

    @Query("SELECT * FROM characters")
    fun getAllCharactersForTest(): LiveData<List<StarWarsCharactersEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCharacter(character: StarWarsCharactersEntity): Long

    @Delete
    fun deleteCharacter(character: StarWarsCharactersEntity)

}