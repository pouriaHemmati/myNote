package com.pouria.mynote.mvp.details

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.covid19.base.BaseActivity
import com.pouria.mynote.widgets.CustomSnackMasseg
import com.pouria.note.R
import com.pouria.note.databinding.ActivityDetailNoteBinding
import com.pouria.note.model.NoteModel


class DetailNoteActivity : AppCompatActivity(), IDetailNoteView {


    private lateinit var note: NoteModel
    private lateinit var binding: ActivityDetailNoteBinding
    private lateinit var detailNotePresenter: DetailNotePresenter
    private var exit = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        detailNotePresenter = DetailNotePresenter(this, DetailNoteInteractor())

        val noteId = intent.getStringExtra("noteId").toString()
        detailNotePresenter.callDetailNote(noteId)

        clickListener()
    }


    private fun clickListener() {
        binding.btnDelete.setOnClickListener {

            if (exit){
                detailNotePresenter.delete(note)
            } else {
                CustomSnackMasseg.showSnack(BaseActivity.applicationContext(),BaseActivity.applicationContext().getString(R.string.snackBack),binding.layDetails)
                exit = true

                Handler().postDelayed(Runnable { exit = false }, 3 * 1000)
            }
        }

        binding.btnUpdate.setOnClickListener {
            update()
        }
    }

    private fun update() {
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

        note.title = binding.edtTitle.text.toString()
        note.description = binding.edtDetails.text.toString()
        detailNotePresenter.update(note)
    }


    override fun onBackPressed() {

        if (exit){
            update()
            super.onBackPressed()
        } else {
            CustomSnackMasseg.showSnack(BaseActivity.applicationContext(),BaseActivity.applicationContext().getString(R.string.snackBack),binding.layDetails)
            exit = true

            Handler().postDelayed(Runnable { exit = false }, 3 * 1000)
        }


    }

    override fun successDetailNotes(noteModel: NoteModel) {
        note = noteModel
        binding.edtTitle.setText(note.title)
        binding.edtDetails.setText(note.description)
    }

    override fun errorDetailNotes(error: String) {

    }

    override fun successDeleteNotes() {
        finish()
    }

    override fun errorDeleteNotes(error: String) {
        finish()
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun successUpdateNotes() {
        CustomSnackMasseg.showSnack(BaseActivity.applicationContext(),BaseActivity.applicationContext().getString(R.string.successUpdate),binding.layDetails)
    }

    override fun errorUpdateNotes(error: String) {
    }
}