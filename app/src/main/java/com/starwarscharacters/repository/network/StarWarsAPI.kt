package com.starwarscharacters.repository.network

import com.starwarscharacters.repository.model.CharacterProperties
import com.starwarscharacters.repository.model.StarWarsCharacters
import com.starwarscharacters.repository.model.StarWarsCharactersResult
import retrofit2.Call
import retrofit2.http.*


interface StarWarsAPI {

    @GET("people")
    fun getAll():Call<StarWarsCharacters>

    @POST("people")
    fun create(@Body body: CharacterProperties):Call<StarWarsCharactersResult>

    @GET("people/{id}")
    fun getById(@Path("id") id: Number?):Call<StarWarsCharactersResult>

    @DELETE("delete/{id}")
    fun delete(@Path("id") id: Number?):Call<StarWarsCharactersResult>
}