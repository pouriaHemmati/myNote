package com.pouria.mynote.mvp.createNote

import com.pouria.note.model.NoteModel
import com.pouria.mynote.mvp.createNote.ICreateNoteInteractor.IInsertNotesFinishListener


class CreateNotePresenter(var iCreateNoteView: ICreateNoteView, var iCreateNoteInteractor: ICreateNoteInteractor):ICreateNotePresenter {



    override fun insert(note: NoteModel) {
        iCreateNoteInteractor.insert(note , object  : IInsertNotesFinishListener{
            override fun successInsertNotes() {
                iCreateNoteView.successCreateNotes()
            }

        })
    }


}

