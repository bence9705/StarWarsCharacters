package com.starwarscharacters.repository.model

data class StarWarsCharacters(val message: String?, val total_records: Number?, val total_pages: Number?, val previous: String?, val next: String?, val results: List<StarWarsCharactersResult>?)