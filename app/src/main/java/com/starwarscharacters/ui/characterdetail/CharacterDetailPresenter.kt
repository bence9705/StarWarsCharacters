package com.starwarscharacters.ui.characterdetail

import com.starwarscharacters.events.EventBus
import com.starwarscharacters.events.RxBusEvent
import com.starwarscharacters.ui.Presenter
import com.starwarscharacters.ui.characters.CharacterListScreen
import io.reactivex.android.schedulers.AndroidSchedulers

object CharacterDetailPresenter: Presenter<CharacterDetailScreen?>() {

    override fun attachScreen(screen: CharacterDetailScreen?) {
        super.attachScreen(screen)

        EventBus.listen(RxBusEvent.StarWarsCharactersEvent::class.java)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
            }
    }


}