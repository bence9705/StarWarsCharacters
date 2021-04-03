package com.starwarscharacters.ui.characters.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.starwarscharacters.R
import kotlinx.android.synthetic.main.character_row.view.*


class CharacterAdapter: RecyclerView.Adapter<CharacterAdapter.ViewHolder> {

    val context: Context
    var characterList = mutableListOf<Character>()

    constructor(context: Context) {
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.character_row, parent, false)
//        val view = LayoutInflater.from(context).inflate(R.layout.character_row, parent, false)
        return ViewHolder(view)
    }


    inner class ViewHolder(characterView: View) : RecyclerView.ViewHolder(characterView) {
        val tvCityName = characterView.tvCharacterName
        val cardView = characterView.cardView
        val btnDelete = characterView.btnDelete
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       //TDOOOO
    }

    override fun getItemCount(): Int {
        return characterList.size
//        return 1
    }
}