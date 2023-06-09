package com.devnic.hiltkotlin.database

import com.devnic.hiltkotlin.model.modelbd.NoteModel


data class StateUi(
    val title: String = "",
    val resume: String = "",
    val onChangeTitle: (String) -> Unit = {},
    val onChangeResume: (String) -> Unit = {},
    val loading: Boolean = false,
    val isSuccess: Boolean = false,
    val insert: () -> Unit = {},
    val setOnNavNoteList : (() -> Unit) -> Unit = {},
    val onNavNoteList : () -> Unit = {}
)
