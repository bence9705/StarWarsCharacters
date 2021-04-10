package com.starwarscharacters.ui.characters

import com.starwarscharacters.model.Character

interface CharacterListScreen {
    fun showCharacters(characterList: List<Character>);
}