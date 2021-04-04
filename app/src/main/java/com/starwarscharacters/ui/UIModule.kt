package com.starwarscharacters.ui

import android.content.Context
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

}