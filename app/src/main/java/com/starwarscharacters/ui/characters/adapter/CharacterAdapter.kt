package com.starwarscharacters.ui.characters.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.starwarscharacters.R
import com.starwarscharacters.repository.database.AppDatabase
import kotlinx.android.synthetic.main.character_row.view.*
import com.starwarscharacters.repository.model.StarWarsCharactersEntity
import com.starwarscharacters.ui.characterdetail.CharacterDetailActivity

class CharacterAdapter: RecyclerView.Adapter<CharacterAdapter.ViewHolder> {

    val context: Context
    var characterList: MutableList<StarWarsCharactersEntity> =
        mutableListOf<StarWarsCharactersEntity>()


    constructor(context: Context) {
        this.context = context
        notifyDataSetChanged()
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

        holder.tvCharacterName.text = character?.name

        holder.btnDelete.setOnClickListener {
            removeCharacter(holder.adapterPosition)

        }

        holder.cardView.setOnClickListener {
            val intent = Intent(context, CharacterDetailActivity::class.java)
            intent.putExtra("name", characterList?.get(position).name.toString())
            intent.putExtra("height", characterList?.get(position).height)
            intent.putExtra("mass", characterList?.get(position).mass)
            intent.putExtra("hair_color", characterList?.get(position).hair_color)
            intent.putExtra("skin_color", characterList?.get(position).skin_color)
            intent.putExtra("eye_color", characterList?.get(position).eye_color)
            intent.putExtra("birth_year", characterList?.get(position).birth_year)
            intent.putExtra("gender", characterList?.get(position).gender)
            intent.putExtra("homeworld", characterList?.get(position).homeworld)
            context.startActivity(intent)
//            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    fun setCharacters(characters: List<StarWarsCharactersEntity>) {
        this.characterList.clear()
        this.characterList.addAll(characters)
        notifyDataSetChanged()
    }

    fun addCharacter(character: StarWarsCharactersEntity){
        characterList.add(character)
        notifyItemInserted(characterList.lastIndex)
        AppDatabase.getInstance(context).starWarsCharacterDao().insertCharacter(character)
    }

    fun removeCharacter(position: Int){

        var characterListDB =
            AppDatabase.getInstance(context).starWarsCharacterDao().getAllCharacters();
        characterListDB.forEach(){
        }


        var characterToDelete = characterList.get(position)
        characterList.removeAt(position)
        notifyItemRemoved(position)

        AppDatabase.getInstance(context).starWarsCharacterDao().deleteCharacter(characterToDelete)

        var characterListDBafterRemove =
            AppDatabase.getInstance(context).starWarsCharacterDao().getAllCharacters();

        characterListDBafterRemove.forEach(){
            println(it)
        }
    }

}