package com.starwarscharacters.ui.characterdetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.starwarscharacters.R
import com.starwarscharacters.injector
import com.starwarscharacters.repository.model.CharacterProperties
import com.starwarscharacters.repository.model.StarWarsCharactersResult
import kotlinx.android.synthetic.main.activity_character_detail.*
import javax.inject.Inject

class CharacterDetailActivity : AppCompatActivity(), CharacterDetailScreen{

    @Inject
    lateinit var characterDetailPresenter: CharacterDetailPresenter;
    val name: String = ""
    val height: String = ""
    val mass: String = ""
    val hair_color: String = ""
    val skin_color: String = ""
    val eye_color: String = ""
    val birth_year: String = ""
    val gender: String = ""
    val homeworld: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_detail)
        injector.inject(this);
        val name = intent.getStringExtra("name")
        val height = intent.getStringExtra("height")
        val mass = intent.getStringExtra("mass")
        val hair_color = intent.getStringExtra("hair_color")
        val skin_color = intent.getStringExtra("skin_color")
        val eye_color = intent.getStringExtra("eye_color")
        val birth_year = intent.getStringExtra("birth_year")
        val gender = intent.getStringExtra("gender")
        val homeworld = intent.getStringExtra("homeworld")
        characterDetailPresenter.attachScreen(this)
        nameFromData.text = name
        heightFromData.text = height
        massFromData.text = mass
        hairColorFromData.text = hair_color
        skinColorFromData.text = skin_color
        eyeColorFromData.text = eye_color
        birthYearFromData.text = birth_year
        genderFromData.text = gender
        homeworldFromData.text = homeworld
    }


    override fun showError(errorMsg: String) {

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
//        characterDetailPresenter.queryCharacterDeatil(1);
    }
}