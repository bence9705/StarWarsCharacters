package com.starwarscharacters.ui.characters

import android.os.Bundle
import android.view.Menu
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.input.getInputField
import com.afollestad.materialdialogs.input.input
import com.starwarscharacters.R
import com.starwarscharacters.model.Character
import com.starwarscharacters.ui.characters.adapter.CharacterAdapter

class CharacterListActivity : AppCompatActivity(), CharacterListScreen {

    lateinit var characterAdapter: CharacterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            showAddCityDialog()
        }
    }

    private fun showAddCityDialog() {

        MaterialDialog(this).show {
            noAutoDismiss()
            title(text = "Add City Name")
            input()

            positiveButton(text="Add") {
                val characterName = it.getInputField().text.toString()
                if (characterName.isNotEmpty()) {
                    saveCharacter(Character())
                    it.dismiss()
                } else {
                    it.getInputField().error = "Required"
                }
            }
            negativeButton(text="Dismiss") {
                it.dismiss()
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun showCharacters(characterList: List<Character>) {
        characterAdapter.setCharacters(characterList);
    }

    override fun onStart() {
        super.onStart()
        CharacterListPresenter.attachScreen(this)
    }

    override fun onStop() {
        CharacterListPresenter.detachScreen()
        super.onStop()
    }

    override fun onResume() {
        super.onResume()
        initRecyclerView()
        CharacterListPresenter.queryCharacters(this)
    }

    private fun initRecyclerView() {
        characterAdapter = CharacterAdapter(this);
        val rv: RecyclerView = findViewById(R.id.listCharacters)
        rv.adapter = characterAdapter;
    }

    fun saveCharacter(newCharacter: Character) {
        Thread {

            runOnUiThread {
                characterAdapter.addCharacter(newCharacter)
            }
        }.start()

    }
}