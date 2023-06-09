package com.devnic.hiltkotlin.repository

import com.devnic.hiltkotlin.database.NoteDao
import com.devnic.hiltkotlin.model.modelbd.NoteModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryNote @Inject constructor(private val dao: NoteDao) {

    val noteList : Flow<List<NoteModel>> = dao.getNotes()

    suspend fun insertNote(note: NoteModel) = dao.insertNote(note)

    suspend fun deleteNote(note: NoteModel) = dao.deleteNote(note)

}