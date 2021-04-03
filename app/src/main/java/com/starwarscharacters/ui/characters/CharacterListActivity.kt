package com.starwarscharacters.ui.characters

import android.os.Bundle
import android.view.Menu
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
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
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun showCharacters(characterList: List<Character>) {
        TODO("Not yet implemented")
    }

    override fun showAbout() {
        TODO("Not yet implemented")
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
}