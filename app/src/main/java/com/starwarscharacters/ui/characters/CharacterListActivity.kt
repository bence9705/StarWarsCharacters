package com.starwarscharacters.ui.characters

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.input.getInputField
import com.afollestad.materialdialogs.input.input
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.gson.GsonBuilder
import com.starwarscharacters.R
import com.starwarscharacters.injector
import com.starwarscharacters.repository.model.StarWarsCharacter
import com.starwarscharacters.repository.model.StarWarsCharacters
import com.starwarscharacters.repository.network.StarWarsAPI
import com.starwarscharacters.ui.characters.adapter.CharacterAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject


class CharacterListActivity : AppCompatActivity(), CharacterListScreen {

    @Inject
    lateinit var characterListPresenter: CharacterListPresenter;
    lateinit var characterAdapter: CharacterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injector.inject(this)

        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            loadCharacters()
            loadCharacter()
            showAddCityDialog()
        }
//        characterListPresenter.queryCharacters(this);
    }

    override fun showCharacters() {

    }

    override fun loadCharacters() {
//        var starWarsCharacters=StarWarsCharacters("test","test", 0, 0,)
        var starWarsCharacters:StarWarsCharacters?

        val gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
//            .baseUrl("https://www.swapi.tech/api/")
            .baseUrl("https://swapi.dev/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val starWarsAPI = retrofit.create(StarWarsAPI::class.java)

        val characters = starWarsAPI.getAll()

        characters.enqueue(object : Callback<StarWarsCharacters> {
            override fun onFailure(call: Call<StarWarsCharacters>, t: Throwable) {
                System.out.println("kebab1")
                System.out.println(t.message)
            }

            override fun onResponse(
                call: Call<StarWarsCharacters>,
                response: Response<StarWarsCharacters>
            ) {
                val swCharacters = StarWarsCharacters(response.body()?.count,response.body()?.next,response.body()?.previous,response.body()?.results)

                starWarsCharacters = swCharacters
                System.out.println("kebab2")
                System.out.println(starWarsCharacters)
            }
        })
    }

    fun loadCharacter() {

        var starWarsCharacter: StarWarsCharacter? = null

        val gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
//            .baseUrl("https://www.swapi.tech/api/")
            .baseUrl("https://swapi.dev/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val starWarsAPI = retrofit.create(StarWarsAPI::class.java)

        val characters = starWarsAPI.getById(1)

        characters.enqueue(object : Callback<StarWarsCharacter> {
            override fun onFailure(call: Call<StarWarsCharacter>, t: Throwable) {
                System.out.println("kebab3")
                System.out.println(t.message)
            }

            override fun onResponse(
                call: Call<StarWarsCharacter>,
                response: Response<StarWarsCharacter>
            ) {
                System.out.println("kebab4")
                System.out.println(response.body()?.name.toString())
                val swCharacter = StarWarsCharacter(response.body()?.name,response.body()?.height,response.body()?.mass,response.body()?.hair_color,response.body()?.skin_color,response.body()?.eye_color,response.body()?.birth_year,response.body()?.gender,response.body()?.homeworld,response.body()?.films,response.body()?.species,response.body()?.vehicles,response.body()?.starships,response.body()?.created,response.body()?.edited,response.body()?.url)
                starWarsCharacter = swCharacter

                System.out.println(starWarsCharacter)
            }
        })
    }

//        val characterById = starWarsAPI.getByIdAll()

    private fun showAddCityDialog() {

        MaterialDialog(this).show {
            noAutoDismiss()
            title(text = "Add City Name")
            input()

            positiveButton(text = "Add") {
                val characterName = it.getInputField().text.toString()
                if (characterName.isNotEmpty()) {
//                    saveCharacter(Character())
                    it.dismiss()
                } else {
                    it.getInputField().error = "Required"
                }
            }
            negativeButton(text = "Dismiss") {
                it.dismiss()
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

//    override fun showCharacters(characterList: List<Character>) {
////        characterAdapter.setCharacters(characterList);
//    }

    override fun onStart() {
        super.onStart()
        characterListPresenter.attachScreen(this)
    }

    override fun onStop() {
        characterListPresenter.detachScreen()
        super.onStop()
    }

    override fun onResume() {
        super.onResume()
        initRecyclerView()
        characterListPresenter.queryCharacters(this)
    }

    private fun initRecyclerView() {
        characterAdapter = CharacterAdapter(this);
        val rv: RecyclerView = findViewById(R.id.listCharacters)
        rv.adapter = characterAdapter;
    }

    fun saveCharacter(newCharacter: Character) {
        Thread {

            runOnUiThread {
                characterAdapter.addCharacter(newCharacter)
            }
        }.start()

    }
}