package com.starwarscharacters.ui.characters

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.starwarscharacters.R
import com.starwarscharacters.injector
import com.starwarscharacters.repository.model.StarWarsCharactersEntity
import com.starwarscharacters.ui.about.AboutActivity
import com.starwarscharacters.ui.characters.adapter.CharacterAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.create_character.view.*
import javax.inject.Inject


class CharacterListActivity : AppCompatActivity(), CharacterListScreen {

    @Inject
    lateinit var characterListPresenter: CharacterListPresenter;
    lateinit var characterAdapter: CharacterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injector.inject(this)

        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            showAddCharacterDialog()
            characterAdapter.notifyDataSetChanged()
        }
    }

    override fun showCharacters(characters: List<StarWarsCharactersEntity>) {
        characterAdapter.setCharacters(characters)
    }

    private fun showAddCharacterDialog() {

    val mDialogView = LayoutInflater.from(this).inflate(R.layout.create_character, null)
        val mBuilder = AlertDialog.Builder(this).setView(mDialogView).setTitle("Create New Character!")
        val mAlertDialog = mBuilder.show()

        mDialogView.saveButton.setOnClickListener{
            mAlertDialog.dismiss()
            val name = mDialogView.name.text.toString()
            val height = mDialogView.characterHeight.text.toString()
            val mass = mDialogView.mass.text.toString()
            val hair_color = mDialogView.hair_color.text.toString()
            val skin_color = mDialogView.skin_color.text.toString()
            val eye_color = mDialogView.eye_color.text.toString()
            val birth_year = mDialogView.birth_year.text.toString()
            val gender = mDialogView.gender.text.toString()
            val homeworld = mDialogView.homeworld.text.toString()

            characterAdapter.addCharacter(StarWarsCharactersEntity(null,name,height,mass,hair_color,skin_color,eye_color,birth_year,gender,homeworld,null,null,null))
        }

        mDialogView.cancelButton.setOnClickListener{
            mAlertDialog.dismiss()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_about -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onStart() {
        super.onStart()
        characterListPresenter.attachScreen(this)
    }

    override fun onStop() {
        characterListPresenter.detachScreen()
        super.onStop()
    }

    override fun onResume() {
        super.onResume()
        characterListPresenter.queryCharacters(this)
        initRecyclerView()
        characterAdapter.notifyDataSetChanged()
    }

    private fun initRecyclerView() {
        characterAdapter = CharacterAdapter(this);
        charactersRecyclerView.adapter = characterAdapter
    }

//    fun saveCharacter(newCharacter: StarWarsCharactersEntity) {
//        Thread {
//
//            runOnUiThread {
//                characterAdapter.addCharacter(newCharacter)
//            }
//        }.start()
//
//    }
}