package com.starwarscharacters.repository.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "characters")
data class CharacterPropertiesEntity(
    @PrimaryKey(autoGenerate = true)
    var characterId: Long?,

    @ColumnInfo(name = "height")
    var height: String?,

    @ColumnInfo(name = "mass")
    var mass: String?,

    @ColumnInfo(name = "hair_color")
    var hair_color: String?,

    @ColumnInfo(name = "skin_color")
    var skin_color: String?,

    @ColumnInfo(name = "eye_color")
    var eye_color: String?,

    @ColumnInfo(name = "birth_year")
    var birth_year: String?,

    @ColumnInfo(name = "gender")
    var gender: String?,

    @ColumnInfo(name = "created")
    var created: String?,

    @ColumnInfo(name = "edited")
    var edited: String?,

    @ColumnInfo(name = "name")
    var name: String?,

    @ColumnInfo(name = "homeworld")
    var homeworld: String?,

    @ColumnInfo(name = "url")
    var url: String?
)
