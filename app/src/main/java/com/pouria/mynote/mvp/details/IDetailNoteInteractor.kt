package com.pouria.mynote.mvp.details

import com.pouria.note.model.NoteModel

interface IDetailNoteInteractor {
    fun detailNote(noteId : String ,iDetailNotesFinishListener: IDetailNotesFinishListener)
    interface IDetailNotesFinishListener{
        fun successDetailNotes(noteModel: NoteModel)
        fun errorDetailNotes(error :String)
    }

    fun delete(note : NoteModel, iDeleteNotesFinishListener: IDeleteNotesFinishListener)
    interface IDeleteNotesFinishListener{
        fun successDeleteNotes()
        fun errorDeleteNotes(error :String)
    }
    fun update(note : NoteModel, iUpdateNotesFinishListener: IUpdateNotesFinishListener)
    interface IUpdateNotesFinishListener{
        fun successUpdateNotes()
        fun errorUpdateNotes(error :String)
    }
}
