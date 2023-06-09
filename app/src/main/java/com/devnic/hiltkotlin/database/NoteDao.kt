package com.devnic.hiltkotlin.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.devnic.hiltkotlin.model.modelbd.NoteModel
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Insert()
    suspend fun insertNote(noteModel: NoteModel)

    @Update()
    suspend fun updateNote(noteModel: NoteModel)

    @Delete
    suspend fun deleteNote(noteModel: NoteModel)

    @Query("SELECT * FROM Notes ORDER BY ID ASC")
    fun getNotes(): Flow<List<NoteModel>>

    @Query("INSERT INTO Notes(TITLE,RESUME)VALUES('Nota 1','contenido de la nota')")
    suspend fun insertDefault()

}