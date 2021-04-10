package com.starwarscharacters.ui

import android.content.Context
import com.starwarscharacters.ui.about.AboutPresenter
import com.starwarscharacters.ui.characterdetail.CharacterDetailPresenter
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Singleton
import com.starwarscharacters.ui.characters.CharacterListPresenter

@Module
class UIModule(private val context: Context) {
    @Provides
    fun context() = context

    @Provides
    @Singleton
    fun characterListPresenter() = CharacterListPresenter

    @Provides
    @Singleton
    fun characterDetailPresenter() = CharacterDetailPresenter

    @Provides
    @Singleton
    fun aboutPresenter() = AboutPresenter
}