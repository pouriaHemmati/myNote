package com.pouria.mynote.mvp.createNote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.covid19.base.BaseActivity
import com.pouria.note.R
import com.pouria.note.databinding.ActivityCreateNoteBinding
import com.pouria.note.model.NoteModel
import com.pouria.note.room.MyDatabase
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CreateNoteActivity : AppCompatActivity(),ICreateNoteView {

    private lateinit var binding: ActivityCreateNoteBinding
    private lateinit var createNotePresenter: CreateNotePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        createNotePresenter = CreateNotePresenter(this , CreateNoteInteractor())

        binding.btnInsert.setOnClickListener {
            insert()
        }
    }



    private fun insert() {
        binding.customEdtTitle.error = null
        binding.customEdtDetails.error = null
        if (binding.edtTitle.text.isEmpty()) {
            binding.customEdtTitle.error = BaseActivity.applicationContext().getString(R.string.errorTitle)
            binding.edtTitle.requestFocus()
            return
        }
        if (binding.edtDetails.text.isEmpty()){
            binding.customEdtDetails.error = BaseActivity.applicationContext().getString(R.string.errorDetails)
            binding.edtDetails.requestFocus()
            return
        }

        val note = NoteModel()
        note.title = binding.edtTitle.text.toString()
        note.description = binding.edtDetails.text.toString()
        createNotePresenter.insert(note)
    }

    override fun successCreateNotes() {
        finish()
    }
}