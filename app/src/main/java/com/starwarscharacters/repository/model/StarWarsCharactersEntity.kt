package com.starwarscharacters.repository.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class StarWarsCharactersEntity(
    @PrimaryKey(autoGenerate = true)
    var characterId: Long?,

    @ColumnInfo(name = "name")
    val name: String?,

    @ColumnInfo(name = "height")
    val height: String?,

    @ColumnInfo(name = "mass")
    val mass: String?,

    @ColumnInfo(name = "hair_color")
    val hair_color: String?,

    @ColumnInfo(name = "skin_color")
    val skin_color: String?,

    @ColumnInfo(name = "eye_color")
    val eye_color: String?,

    @ColumnInfo(name = "birth_year")
    val birth_year: String?,

    @ColumnInfo(name = "gender")
    val gender: String?,

    @ColumnInfo(name = "homeworld")
    val homeworld: String?,

    @ColumnInfo(name = "created")
    val created: String?,

    @ColumnInfo(name = "edited")
    val edited: String?,

    @ColumnInfo(name = "url")
    val url: String?
)