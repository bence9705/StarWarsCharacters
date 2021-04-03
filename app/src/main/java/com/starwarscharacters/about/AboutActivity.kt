package com.starwarscharacters.about

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.starwarscharacters.R
import com.starwarscharacters.detail.CharacterDetailScreen

class AboutActivity : AppCompatActivity(), CharacterDetailScreen {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
    }
}