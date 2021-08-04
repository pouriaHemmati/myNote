package com.pouria.mynote.mvp.details

import com.pouria.note.model.NoteModel
import com.pouria.mynote.mvp.details.IDetailNoteInteractor.IDetailNotesFinishListener
import com.pouria.mynote.mvp.details.IDetailNoteInteractor.IDeleteNotesFinishListener
import com.pouria.mynote.mvp.details.IDetailNoteInteractor.IUpdateNotesFinishListener

class DetailNotePresenter(var iDetailNoteView: IDetailNoteView, var iDetailNoteInteractor: IDetailNoteInteractor):IDetailNotePresenter {

    override fun callDetailNote(noteId : String) {
        iDetailNoteInteractor.detailNote(noteId ,object : IDetailNotesFinishListener {
            override fun successDetailNotes(noteModel:NoteModel) {
                iDetailNoteView.successDetailNotes(noteModel)
            }

            override fun errorDetailNotes(error: String) {
                iDetailNoteView.errorDetailNotes(error)
            }
        })
    }

    override fun delete(note: NoteModel) {
        iDetailNoteInteractor.delete(note , object  : IDeleteNotesFinishListener{
            override fun successDeleteNotes() {
                iDetailNoteView.successDeleteNotes()
            }

            override fun errorDeleteNotes(error: String) {
                iDetailNoteView.errorDetailNotes(error)
            }
        })
    }

    override fun update(note: NoteModel) {
        iDetailNoteInteractor.update(note , object  : IUpdateNotesFinishListener{
            override fun successUpdateNotes() {
                iDetailNoteView.successUpdateNotes()
            }

            override fun errorUpdateNotes(error: String) {
                iDetailNoteView.errorUpdateNotes(error)
            }
        })
    }


}

