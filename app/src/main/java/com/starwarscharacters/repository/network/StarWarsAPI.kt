package com.starwarscharacters.repository.network

import com.starwarscharacters.repository.model.CharacterProperties
import com.starwarscharacters.repository.model.StarWarsCharacter
import com.starwarscharacters.repository.model.StarWarsCharacters
import retrofit2.Call
import retrofit2.http.*


interface StarWarsAPI {

    @GET("people")
    fun getAll():Call<StarWarsCharacters>

    @POST("people")
    fun create(@Body body: CharacterProperties):Call<StarWarsCharacter>

    @GET("people/{id}")
    fun getById(@Path("id") id: Number?):Call<StarWarsCharacter>

    @DELETE("delete/{id}")
    fun delete(@Path("id") id: Number?):Call<StarWarsCharacter>
}