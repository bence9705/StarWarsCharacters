package com.starwarscharacters

import com.starwarscharacters.ui.UIModule
import com.starwarscharacters.ui.characters.CharacterListActivity
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [UIModule::class])
interface StarWarsCharacterApplicationComponent {
    fun inject(characterListActivity: CharacterListActivity)
}