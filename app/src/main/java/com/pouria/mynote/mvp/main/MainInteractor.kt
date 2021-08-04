package com.pouria.mynote.mvp.main

import com.covid19.base.BaseActivity
import com.pouria.note.R
import com.pouria.note.room.MyDatabase


class MainInteractor : IMainInteractor {

    private lateinit var db: MyDatabase
    override fun notes(iNotesFinishListener: IMainInteractor.INotesFinishListener) {
        db = MyDatabase.getInstance(BaseActivity.applicationContext())

        val listNote = db.daoNote().getAll()
        if (listNote.isEmpty()){
            iNotesFinishListener.errorNotes(BaseActivity.applicationContext().getString(R.string.insert))
        } else{
            iNotesFinishListener.successNotes(listNote)
        }
    }


}