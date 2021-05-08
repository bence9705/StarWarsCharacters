package com.starwarscharacters.mock

import com.starwarscharacters.repository.model.CharacterProperties
import com.starwarscharacters.repository.model.StarWarsCharacters
import com.starwarscharacters.repository.model.StarWarsCharactersEntity
import com.starwarscharacters.repository.model.StarWarsCharactersResult
import com.starwarscharacters.repository.network.StarWarsAPI
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class MockStarWarsAPI: StarWarsAPI {
    override fun getAll(): Call<StarWarsCharacters> {

        val starWarsCharactersResult1 = StarWarsCharactersResult( "Yoda", "50", "30", "white", "green", "brown", "unkown", "male", "unkown", null, null, null,null,null,null, null)
        val starWarsCharactersResult2 = StarWarsCharactersResult("Obi", "180", "80", "white", "green", "brown", "unkown", "male", "unkown", null, null, null,null,null,null, null)
        val starWarsCharactersResult3 = StarWarsCharactersResult( "R2D2", "80", "60", "white", "green", "brown", "unkown", "male", "unkown", null, null, null,null,null,null, null)

        val results = ArrayList<StarWarsCharactersResult>()
        results.add(starWarsCharactersResult1)
        results.add(starWarsCharactersResult2)
        results.add(starWarsCharactersResult3)
        val starWarsCharacter = StarWarsCharacters(3,null,0,results)

        val call = object : Call<StarWarsCharacters> {
            @Throws(IOException::class)
            override fun execute(): Response<StarWarsCharacters> {
                return Response.success(starWarsCharacter)
            }

            override fun enqueue(callback: Callback<StarWarsCharacters>) {

            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {

            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun clone(): Call<StarWarsCharacters> {
                return this
            }

            override fun request(): Request? {
                return null
            }
        }

        return call
    }

    override fun create(body: CharacterProperties): Call<StarWarsCharactersResult> {
        TODO("Not yet implemented")
    }

    override fun getById(id: Number?): Call<StarWarsCharactersResult> {
        val starWarsCharactersResult1 = StarWarsCharactersResult( "Yoda", "50", "30", "white", "green", "brown", "unkown", "male", "unkown", null, null, null,null,null,null, null)

        val call = object : Call<StarWarsCharactersResult> {
            @Throws(IOException::class)
            override fun execute(): Response<StarWarsCharactersResult> {
                return Response.success(starWarsCharactersResult1)
            }

            override fun enqueue(callback: Callback<StarWarsCharactersResult>) {

            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {

            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun clone(): Call<StarWarsCharactersResult> {
                return this
            }

            override fun request(): Request? {
                return null
            }
        }

        return call
    }

    override fun delete(id: Number?): Call<StarWarsCharactersResult> {
        TODO("Not yet implemented")
    }
}