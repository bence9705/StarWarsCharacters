package com.starwarscharacters.ui.characterdetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.starwarscharacters.R
import com.starwarscharacters.injector
import com.starwarscharacters.repository.model.CharacterProperties
import com.starwarscharacters.repository.model.StarWarsCharactersResult
import javax.inject.Inject

class CharacterDetailActivity : AppCompatActivity(), CharacterDetailScreen{

    @Inject
    lateinit var characterDetailPresenter: CharacterDetailPresenter;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_detail)
        injector.inject(this);

    }

    override fun showCharacterDetails(characterData: CharacterProperties) {
        //TODOO("Not yet implemented")
    }

    override fun showError(errorMsg: String) {
        //TODOO("Not yet implemented")
    }

    override fun onStart() {
        super.onStart()
        characterDetailPresenter.attachScreen(this)
    }

    override fun onStop() {
        characterDetailPresenter.detachScreen()
        super.onStop()
    }

    override fun onResume() {
        super.onResume()
        characterDetailPresenter.queryCharacterDeatil(1);
    }
}