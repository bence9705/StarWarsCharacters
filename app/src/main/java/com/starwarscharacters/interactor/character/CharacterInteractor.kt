package com.starwarscharacters.interactor.character

import com.google.gson.GsonBuilder
import com.starwarscharacters.repository.model.CharacterProperties
import com.starwarscharacters.repository.model.StarWarsCharacter
import com.starwarscharacters.repository.model.StarWarsCharacters
import com.starwarscharacters.repository.model.StarWarsCharactersResult
import com.starwarscharacters.repository.network.StarWarsAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class CharacterInteractor @Inject constructor(private var starWarsAPI: StarWarsAPI) {

    fun getCharacters(): StarWarsCharacters? {
        var starWarsCharacters: StarWarsCharacters? = null

        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.swapi.tech/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val starWarsAPI = retrofit.create(StarWarsAPI::class.java)

        val characters = starWarsAPI.getAll()

        characters.enqueue(object : Callback<StarWarsCharacters> {
            override fun onFailure(call: Call<StarWarsCharacters>, t: Throwable) {
                System.out.println(t.message)
            }

            override fun onResponse(
                call: Call<StarWarsCharacters>,
                response: Response<StarWarsCharacters>
            ) {
                val swCharacters = StarWarsCharacters(response.body()?.count,response.body()?.next,response.body()?.previous,response.body()?.results)
                starWarsCharacters = swCharacters
                System.out.println(starWarsCharacters)

            }
        })
        return starWarsCharacters
    }

    fun getCharacterById(id: Number?): StarWarsCharacter? {

        var starWarsCharacter: StarWarsCharacter? = null

        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.swapi.tech/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val starWarsAPI = retrofit.create(StarWarsAPI::class.java)

        val character = starWarsAPI.getById(id)

        character.enqueue(object : Callback<StarWarsCharacter> {
            override fun onFailure(call: Call<StarWarsCharacter>, t: Throwable) {
                System.out.println(t.message)
            }

            override fun onResponse(
                call: Call<StarWarsCharacter>,
                response: Response<StarWarsCharacter>
            ) {
                val swCharacter = StarWarsCharacter(response.body()?.name,response.body()?.height,response.body()?.mass,response.body()?.hair_color,response.body()?.skin_color,response.body()?.eye_color,response.body()?.birth_year,response.body()?.gender,response.body()?.homeworld,response.body()?.films,response.body()?.species,response.body()?.vehicles,response.body()?.starships,response.body()?.created,response.body()?.edited,response.body()?.url)
                starWarsCharacter = swCharacter
                System.out.println(starWarsCharacter)
            }
        })
        return starWarsCharacter
    }

    fun deleteCharacterById(id: Number?){

        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.swapi.tech/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val starWarsAPI = retrofit.create(StarWarsAPI::class.java)

        starWarsAPI.delete(id)
    }

    fun createCharacter(characterProperties: CharacterProperties?){

        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.swapi.tech/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val starWarsAPI = retrofit.create(StarWarsAPI::class.java)

        if (characterProperties != null) {
            starWarsAPI.create(characterProperties)
        }
    }
}