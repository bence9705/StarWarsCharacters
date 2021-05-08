package com.starwarscharacters.ui.characters

import com.starwarscharacters.repository.model.CharacterProperties
import com.starwarscharacters.repository.model.StarWarsCharactersEntity


interface CharacterListScreen {
    fun showCharacters(characters: List<StarWarsCharactersEntity>);
//    fun loadCharacters()
}