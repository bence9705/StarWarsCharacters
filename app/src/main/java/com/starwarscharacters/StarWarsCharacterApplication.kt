package com.starwarscharacters

import android.app.Application
import com.starwarscharacters.ui.UIModule

class StarWarsCharacterApplication: Application() {

        lateinit var injector: StarWarsCharacterApplicationComponent

    override fun onCreate() {
        super.onCreate()

        injector = DaggerStarWarsCharacterApplicationComponent.builder().uIModule(UIModule(this)).build()
    }

}