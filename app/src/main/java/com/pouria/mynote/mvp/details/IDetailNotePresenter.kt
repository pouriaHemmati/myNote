package com.pouria.mynote.mvp.details

import com.pouria.note.model.NoteModel

interface IDetailNotePresenter {
     fun callDetailNote(noteId : String)
     fun delete(note: NoteModel)
     fun update(note: NoteModel)
}