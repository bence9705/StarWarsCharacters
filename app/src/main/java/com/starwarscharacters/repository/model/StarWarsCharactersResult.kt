package com.starwarscharacters.repository.model

//data class StarWarsCharactersResult(val uid: String?, val name: String?, val url: String?)
data class StarWarsCharactersResult(val name: String?, val height: String?, val mass: String?, val hair_color: String?, val skin_color: String?, val eye_color: String?, val birth_year: String?, val gender: String?, val homeworld: String?, val films: List<String>?, val species: List<Any>?, val vehicles: List<String>?, val starships: List<String>?, val created: String?, val edited: String?, val url: String?)