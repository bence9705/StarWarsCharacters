package com.starwarscharacters.repository.database

import androidx.room.*
import com.starwarscharacters.repository.model.CharacterPropertiesEntity
import com.starwarscharacters.repository.model.StarWarsCharactersResult

@Dao
interface StarWarsCharactersDAO {
    @Query("SELECT * FROM characters WHERE characterId = :id")
    fun getCharacterById(id: Long) : StarWarsCharactersResult

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCharacter(character: StarWarsCharactersResult): Long

    @Delete
    fun deleteCharacter(character: StarWarsCharactersResult)

    @Update
    fun updateCharacter(character: StarWarsCharactersResult)
}