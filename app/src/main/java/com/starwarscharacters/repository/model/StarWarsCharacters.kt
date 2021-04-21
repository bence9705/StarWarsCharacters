package com.starwarscharacters.repository.model

data class StarWarsCharacters(var message: String?, var total_records: Number?, var total_pages: Number?, var previous: String?, var next: String?, var results: List<StarWarsCharactersResult>?) {
}