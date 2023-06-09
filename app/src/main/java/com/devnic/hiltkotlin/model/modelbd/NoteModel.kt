package com.devnic.hiltkotlin.model.modelbd

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notes")
data class NoteModel(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    var id: Long = 0L,
    @ColumnInfo(name = "TITLE")
    var title: String? = "",
    @ColumnInfo(name = "RESUME")
    var resume: String? = null
)
