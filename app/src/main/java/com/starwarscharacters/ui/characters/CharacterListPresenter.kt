package com.starwarscharacters.ui.characters

import android.content.Context
import androidx.room.ColumnInfo
import com.afollestad.materialdialogs.input.getInputField
import com.google.gson.GsonBuilder
import com.starwarscharacters.events.EventBus
import com.starwarscharacters.events.RxBusEvent
import com.starwarscharacters.interactor.character.CharacterInteractor
import com.starwarscharacters.repository.database.AppDatabase
import com.starwarscharacters.repository.model.StarWarsCharacters
import com.starwarscharacters.repository.model.StarWarsCharactersEntity
import com.starwarscharacters.repository.network.StarWarsAPI
import com.starwarscharacters.ui.Presenter
import com.starwarscharacters.ui.characters.adapter.CharacterAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CharacterListPresenter : Presenter<CharacterListScreen?>() {

    override fun attachScreen(screen: CharacterListScreen?) {
        super.attachScreen(screen)

        EventBus.listen(RxBusEvent.StarWarsCharactersEvent::class.java)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                screen?.showCharacters(it.charaterList)
            }
    }

    override fun detachScreen() {
        super.detachScreen()
    }

    fun queryCharacters(context: Context) {

            var characterList =
                AppDatabase.getInstance(context).starWarsCharacterDao().getAllCharacters();
            if (characterList.size < 1) {
                loadCharacters(context)
            }
        characterList =
            AppDatabase.getInstance(context).starWarsCharacterDao().getAllCharacters()
                EventBus.publish(RxBusEvent.StarWarsCharactersEvent(characterList))

    }

    fun loadCharacters(context: Context){
                val gson = GsonBuilder()
            .setLenient()
            .create()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://swapi.dev/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        val starWarsAPI = retrofit.create(StarWarsAPI::class.java)
        var characterInteractor: CharacterInteractor = CharacterInteractor(starWarsAPI)
        characterInteractor.getCharacters(context)
    }


}