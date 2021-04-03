package com.starwarscharacters.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.starwarscharacters.R

class CharacterDetailActivity : AppCompatActivity(), CharacterDetailScreen{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_detail)
    }
}