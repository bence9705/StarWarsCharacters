package com.starwarscharacters.repository.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.starwarscharacters.repository.model.StarWarsCharactersEntity

@Database(entities = [StarWarsCharactersEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun starWarsCharacterDao(): StarWarsCharactersDAO

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java, "star_wars_database"
                )
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
                    .also { INSTANCE = it }
            }
        }

    }
}