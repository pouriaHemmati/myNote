package com.pouria.mynote.mvp.createNote


import com.covid19.base.BaseActivity
import com.pouria.note.model.NoteModel
import com.pouria.note.room.MyDatabase


class CreateNoteInteractor : ICreateNoteInteractor {

    private lateinit var db: MyDatabase


    override fun insert(note: NoteModel, iInsertNotesFinishListener: ICreateNoteInteractor.IInsertNotesFinishListener) {
        db = MyDatabase.getInstance(BaseActivity.applicationContext())
        db.daoNote().insert(note)
        iInsertNotesFinishListener.successInsertNotes()
    }


}