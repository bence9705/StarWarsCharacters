package com.starwarscharacters.ui.about

import com.starwarscharacters.events.EventBus
import com.starwarscharacters.events.RxBusEvent
import com.starwarscharacters.ui.Presenter
import com.starwarscharacters.ui.characters.CharacterListScreen
import io.reactivex.android.schedulers.AndroidSchedulers

object AboutPresenter: Presenter<AboutScreen?>() {

    override fun attachScreen(screen: AboutScreen?) {
        super.attachScreen(screen)

        EventBus.listen(RxBusEvent.StarWarsCharactersEvent::class.java)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                screen?.showAboutDescription()
            }
    }
}