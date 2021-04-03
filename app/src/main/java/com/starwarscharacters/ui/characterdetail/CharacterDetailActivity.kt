package com.starwarscharacters.ui.characterdetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.starwarscharacters.R
import com.starwarscharacters.model.CharacterResult

class CharacterDetailActivity : AppCompatActivity(), CharacterDetailScreen{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_detail)
    }

    override fun showWeatherDetails(characterData: CharacterResult) {
        TODO("Not yet implemented")
    }

    override fun showError(errorMsg: String) {
        TODO("Not yet implemented")
    }

    override fun onStart() {
        super.onStart()
        CharacterDetailPresenter.attachScreen(this)
    }

    override fun onStop() {
        CharacterDetailPresenter.detachScreen()
        super.onStop()
    }

    override fun onResume() {
        super.onResume()
        CharacterDetailPresenter.queryCharacterDeatil(1);
    }
}