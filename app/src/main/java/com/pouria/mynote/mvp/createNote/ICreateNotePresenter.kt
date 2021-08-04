package com.pouria.mynote.mvp.createNote

import com.pouria.note.model.NoteModel

interface ICreateNotePresenter {
     fun insert(note: NoteModel)
}