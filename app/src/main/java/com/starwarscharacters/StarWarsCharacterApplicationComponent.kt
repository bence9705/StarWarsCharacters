package com.starwarscharacters

import com.starwarscharacters.ui.UIModule
import com.starwarscharacters.ui.about.AboutActivity
import com.starwarscharacters.ui.characterdetail.CharacterDetailActivity
import com.starwarscharacters.ui.characters.CharacterListActivity
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [UIModule::class])
interface StarWarsCharacterApplicationComponent {
    fun inject(characterListActivity: CharacterListActivity)
    fun inject(characterDetailActivity: CharacterDetailActivity)
    fun inject(aboutActivity: AboutActivity)
}