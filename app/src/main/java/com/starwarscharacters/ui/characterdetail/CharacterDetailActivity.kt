package com.starwarscharacters.ui.characterdetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.starwarscharacters.R
import com.starwarscharacters.injector
import com.starwarscharacters.model.CharacterResult
import javax.inject.Inject

class CharacterDetailActivity : AppCompatActivity(), CharacterDetailScreen{

    @Inject
    lateinit var characterDetailPresenter: CharacterDetailPresenter;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_detail)
        injector.inject(this);

    }

    override fun showCharacterDetails(characterData: CharacterResult) {
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