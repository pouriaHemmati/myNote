package com.pouria.mynote.mvp.main

import com.pouria.note.model.NoteModel
import com.pouria.mynote.mvp.main.IMainInteractor.INotesFinishListener

class MainPresenter(var iMainView: IMainView, var iMainInteractor: IMainInteractor):IMainPresenter {

    override fun callNotes() {
        iMainInteractor.notes(object : INotesFinishListener {
            override fun successNotes(noteModels: List<NoteModel>) {
                iMainView.successNotes(noteModels)
            }

            override fun errorNotes(error: String) {
                iMainView.errorNotes(error)
            }
        })
    }



}

