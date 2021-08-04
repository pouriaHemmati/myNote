package com.pouria.mynote.mvp.main

import com.pouria.note.model.NoteModel


interface IMainView {
    fun successNotes(noteModel: List<NoteModel>)
    fun errorNotes(error : String)
}