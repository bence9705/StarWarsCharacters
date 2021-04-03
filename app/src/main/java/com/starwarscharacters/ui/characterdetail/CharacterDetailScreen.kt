package com.starwarscharacters.ui.characterdetail

import com.starwarscharacters.model.CharacterResult

interface CharacterDetailScreen {
    fun showWeatherDetails(characterData: CharacterResult)
    fun showError(errorMsg: String)
}