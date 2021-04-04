package com.starwarscharacters

import android.app.Activity

val Activity.injector: StarWarsCharacterApplicationComponent
    get() {
        return (this.applicationContext as StarWarsCharacterApplication).injector
    }
