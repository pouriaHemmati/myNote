package com.pouria.mynote.mvp.main

import com.pouria.note.model.NoteModel

interface IMainInteractor {
    fun notes(iNotesFinishListener: INotesFinishListener)
    interface INotesFinishListener{
        fun successNotes(noteModel: List<NoteModel>)
        fun errorNotes(error :String)
    }
}
