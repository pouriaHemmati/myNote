package com.pouria.mynote.mvp.details

import android.util.Log
import android.widget.Toast
import com.covid19.base.BaseActivity
import com.pouria.note.model.NoteModel
import com.pouria.note.room.MyDatabase
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class DetailNoteInteractor : IDetailNoteInteractor {

    private lateinit var db: MyDatabase
    override fun detailNote(noteId : String ,iDetailNotesFinishListener: IDetailNoteInteractor.IDetailNotesFinishListener) {
        db = MyDatabase.getInstance(BaseActivity.applicationContext())

        val note = db.daoNote().getNote(noteId)
        if (note.equals("")){
            iDetailNotesFinishListener.errorDetailNotes("خطا")
        } else{
            iDetailNotesFinishListener.successDetailNotes(note)
        }
    }

    override fun delete(note : NoteModel, iDeleteNotesFinishListener: IDetailNoteInteractor.IDeleteNotesFinishListener) {
        db.daoNote().delete(note)
        iDeleteNotesFinishListener.successDeleteNotes()

    }

    override fun update(note: NoteModel, iUpdateNotesFinishListener: IDetailNoteInteractor.IUpdateNotesFinishListener) {
        db.daoNote().update(note)
        iUpdateNotesFinishListener.successUpdateNotes()
        iUpdateNotesFinishListener.errorUpdateNotes("asdasdsadasd")
    }


}