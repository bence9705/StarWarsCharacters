package com.starwarscharacters.ui.about

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.starwarscharacters.R
import com.starwarscharacters.injector
import com.starwarscharacters.ui.characterdetail.CharacterDetailPresenter
import com.starwarscharacters.ui.characterdetail.CharacterDetailScreen
import javax.inject.Inject

class AboutActivity : AppCompatActivity(), AboutScreen {

    @Inject
    lateinit var aboutPresenter: AboutPresenter;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        injector.inject(this)
    }

    override fun showAboutDescription() {
        //TODOO("Not yet implemented")
        aboutPresenter.attachScreen(this);
    }
}