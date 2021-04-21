package com.starwarscharacters.ui.characters

import com.starwarscharacters.repository.model.CharacterProperties


interface CharacterListScreen {
    fun showCharacters();
    fun loadCharacters()
}