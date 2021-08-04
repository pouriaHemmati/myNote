package com.pouria.mynote.mvp.createNote

import com.pouria.note.model.NoteModel

interface ICreateNoteInteractor {

    fun insert(note : NoteModel, iInsertNotesFinishListener: IInsertNotesFinishListener)
    interface IInsertNotesFinishListener{
        fun successInsertNotes()
    }
}
