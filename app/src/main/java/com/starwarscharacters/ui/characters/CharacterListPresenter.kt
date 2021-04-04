package com.starwarscharacters.ui.characters

import android.content.Context
import com.starwarscharacters.Presenter

object CharacterListPresenter: Presenter<CharacterListScreen?>() {
    override fun attachScreen(screen: CharacterListScreen?) {
        super.attachScreen(screen)
    }

    override fun detachScreen() {
        super.detachScreen()
    }

    fun queryCharacters(context: Context){

    }

}