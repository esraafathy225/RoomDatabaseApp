package com.example.myapplication

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "notes")
data class Note(
    @PrimaryKey (autoGenerate = true) val id : Int,
    @ColumnInfo(name = "title_column") val title : String,
    @ColumnInfo(name = "note_column") val note : String)
