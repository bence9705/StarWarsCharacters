package com.starwarscharacters.events

import com.starwarscharacters.repository.model.StarWarsCharactersEntity
import com.starwarscharacters.repository.model.StarWarsCharactersResult

class RxBusEvent {
    data class StarWarsCharactersEvent(val charaterList: List<StarWarsCharactersEntity>)
}