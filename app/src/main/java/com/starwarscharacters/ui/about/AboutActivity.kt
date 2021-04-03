package com.starwarscharacters.ui.about

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.starwarscharacters.R
import com.starwarscharacters.model.CharacterResult
import com.starwarscharacters.ui.characterdetail.CharacterDetailScreen

class AboutActivity : AppCompatActivity(), CharacterDetailScreen {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
    }

    override fun showWeatherDetails(characterData: CharacterResult) {
        TODO("Not yet implemented")
    }

    override fun showError(errorMsg: String) {
        TODO("Not yet implemented")
    }
}