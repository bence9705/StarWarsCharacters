package com.starwarscharacters.interactor.character

import android.content.Context
import com.google.gson.GsonBuilder
import com.starwarscharacters.repository.database.AppDatabase
import com.starwarscharacters.repository.model.CharacterProperties
import com.starwarscharacters.repository.model.StarWarsCharacters
import com.starwarscharacters.repository.model.StarWarsCharactersEntity
import com.starwarscharacters.repository.model.StarWarsCharactersResult
import com.starwarscharacters.repository.network.StarWarsAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class CharacterInteractor @Inject constructor(private var starWarsAPI: StarWarsAPI) {

    fun getCharacters(context: Context) {

        var starWarsCharacters: StarWarsCharacters?
        val characters = starWarsAPI.getAll()

        characters.enqueue(object : Callback<StarWarsCharacters> {
            override fun onFailure(call: Call<StarWarsCharacters>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<StarWarsCharacters>,
                response: Response<StarWarsCharacters>
            ) {
                val swCharacters = StarWarsCharacters(
                    response.body()?.count,
                    response.body()?.next,
                    response.body()?.previous,
                    response.body()?.results
                )
                starWarsCharacters = swCharacters

                swCharacters.results?.forEach {
                    val name = it.name
                    val height = it.height
                    val mass = it.mass
                    val hair_color = it.hair_color
                    val skin_color = it.skin_color
                    val eye_color = it.eye_color
                    val birth_year = it.birth_year
                    val gender = it.gender
                    val homeworld = it.homeworld
                    val created = it.created
                    val edited = it.edited
                    val url = it.url
                    AppDatabase.getInstance(context).starWarsCharacterDao().insertCharacter(
                        StarWarsCharactersEntity(
                            null,
                            name,
                            height,
                            mass,
                            hair_color,
                            skin_color,
                            eye_color,
                            birth_year,
                            gender,
                            homeworld,
                            created,
                            edited,
                            url
                        )
                    )
                };
            }
        })
    }


    fun getCharacterById(id: Number?): StarWarsCharactersResult? {

        var starWarsCharacter: StarWarsCharactersResult? = null

        val retrofit = Retrofit.Builder()
            .baseUrl("https://swapi.dev/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val starWarsAPI = retrofit.create(StarWarsAPI::class.java)

        val character = starWarsAPI.getById(id)

        character.enqueue(object : Callback<StarWarsCharactersResult> {
            override fun onFailure(call: Call<StarWarsCharactersResult>, t: Throwable) {
                System.out.println(t.message)
            }

            override fun onResponse(
                call: Call<StarWarsCharactersResult>,
                response: Response<StarWarsCharactersResult>
            ) {
                val swCharacter = StarWarsCharactersResult(response.body()?.name,response.body()?.height,response.body()?.mass,response.body()?.hair_color,response.body()?.skin_color,response.body()?.eye_color,response.body()?.birth_year,response.body()?.gender,response.body()?.homeworld,response.body()?.films,response.body()?.species,response.body()?.vehicles,response.body()?.starships,response.body()?.created,response.body()?.edited,response.body()?.url)
                starWarsCharacter = swCharacter
            }
        })
        return starWarsCharacter
    }

    fun deleteCharacterById(id: Number?){

        val retrofit = Retrofit.Builder()
            .baseUrl("https://swapi.dev/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val starWarsAPI = retrofit.create(StarWarsAPI::class.java)

        starWarsAPI.delete(id)
    }

    fun createCharacter(characterProperties: CharacterProperties?){

        val retrofit = Retrofit.Builder()
            .baseUrl("https://swapi.dev/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val starWarsAPI = retrofit.create(StarWarsAPI::class.java)

        if (characterProperties != null) {
            starWarsAPI.create(characterProperties)
        }
    }
}