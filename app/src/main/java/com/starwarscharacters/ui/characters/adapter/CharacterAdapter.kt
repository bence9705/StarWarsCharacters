package com.starwarscharacters.ui.characters.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.starwarscharacters.R
import kotlinx.android.synthetic.main.character_row.view.*
import com.starwarscharacters.model.Character
import com.starwarscharacters.ui.characterdetail.CharacterDetailActivity

class CharacterAdapter: RecyclerView.Adapter<CharacterAdapter.ViewHolder> {

    val context: Context
    var characterList = mutableListOf<Character>()

    constructor(context: Context) {
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.character_row, parent, false)
        return ViewHolder(view)
    }


    inner class ViewHolder(characterView: View) : RecyclerView.ViewHolder(characterView) {
        val tvCharacterName = characterView.tvCharacterName
        val cardView = characterView.cardView
        val btnDelete = characterView.btnDelete
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = characterList[position]
        holder.tvCharacterName.text = character.name

        holder.btnDelete.setOnClickListener {
            removeCharacter(holder.adapterPosition)
        }

        holder.cardView.setOnClickListener {
            val intent = Intent(context, CharacterDetailActivity::class.java)
            intent.putExtra("CHARACTER_ID", character.characterId)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    fun setCharacters(characters: List<Character>) {

    }

    fun addCharacter(context: Character){

    }

    fun removeCharacter(position: Int){

    }

}