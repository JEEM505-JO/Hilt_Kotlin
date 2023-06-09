package com.devnic.hiltkotlin.database

import com.devnic.hiltkotlin.model.modelbd.NoteModel

sealed class StateNoteView {
    data class isSuccess(var result: List<NoteModel>) : StateNoteView()
    data class isLoading(var isloading: Boolean) : StateNoteView()
    data class Error(var result: String) : StateNoteView()


}
