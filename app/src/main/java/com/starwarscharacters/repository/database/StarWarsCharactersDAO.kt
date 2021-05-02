package com.starwarscharacters.repository.database

import androidx.room.*
import com.starwarscharacters.repository.model.StarWarsCharactersEntity

@Dao
interface StarWarsCharactersDAO {
    @Query("SELECT * FROM characters")
    fun getAllCharacters(): List<StarWarsCharactersEntity>

    @Query("SELECT * FROM characters WHERE characterId = :id")
    fun getCharacterById(id: Long) : StarWarsCharactersEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCharacter(character: StarWarsCharactersEntity): Long

    @Delete
    fun deleteCharacter(character: StarWarsCharactersEntity)

    @Update
    fun updateCharacter(character: StarWarsCharactersEntity)

    @Query("DELETE FROM characters WHERE characterId = :userId")
    fun deleteByCharacterId(userId: Long)
}