package com.pouria.mynote.mvp.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.pouria.mynote.mvp.details.DetailNoteActivity
import com.pouria.mynote.mvp.createNote.CreateNoteActivity
import com.pouria.note.adapter.AdapterNote
import com.pouria.note.databinding.ActivityMainBinding
import com.pouria.note.model.NoteModel


class MainActivity : AppCompatActivity(),IMainView {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainPresenter = MainPresenter(this,MainInteractor())
        mainPresenter.callNotes()

        binding.btnAdd.setOnClickListener {
            startActivity(Intent(this, CreateNoteActivity::class.java))
        }
    }

    override fun onResume() {
        mainPresenter.callNotes()
        super.onResume()
    }

    override fun successNotes(noteModel: List<NoteModel>) {
        binding.recyclerNote.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.recyclerNote.adapter = AdapterNote(this@MainActivity,noteModel, object : AdapterNote.Listeners {
            override fun onClicked(note: NoteModel) {
                val intent = Intent(this@MainActivity, DetailNoteActivity::class.java)
                intent.putExtra("noteId", "" + note.id)
                startActivity(intent)
            }
        })
    }

    override fun errorNotes(error: String) {
        binding.recyclerNote.adapter = null
        Log.i("main" , error)
    }


}