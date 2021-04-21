package com.starwarscharacters.repository.database

import androidx.room.*
import com.starwarscharacters.repository.model.CharacterPropertiesEntity

@Dao
interface CharacterDAO  {
    @Query("SELECT * FROM characters WHERE characterId = :id")
    fun getCharacterById(id: Long) : CharacterPropertiesEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCharacter(character: CharacterPropertiesEntity): Long

    @Delete
    fun deleteCharacter(character: CharacterPropertiesEntity)

    @Update
    fun updateCharacter(character: CharacterPropertiesEntity)
}