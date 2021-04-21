package com.starwarscharacters.ui.characterdetail

import com.starwarscharacters.repository.model.CharacterProperties

interface CharacterDetailScreen {
    fun showCharacterDetails(characterData: CharacterProperties)
    fun showError(errorMsg: String)
}