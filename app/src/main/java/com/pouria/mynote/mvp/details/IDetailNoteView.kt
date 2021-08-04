package com.pouria.mynote.mvp.details

import com.pouria.note.model.NoteModel


interface IDetailNoteView {
    fun successDetailNotes(noteModel: NoteModel)
    fun errorDetailNotes(error : String)

    fun successDeleteNotes()
    fun errorDeleteNotes(error : String)

    fun successUpdateNotes()
    fun errorUpdateNotes(error : String)
}