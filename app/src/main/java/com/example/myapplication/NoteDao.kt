package com.example.myapplication

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface NoteDao {

    // CRUD     create  read  update   delete

    @Insert
    suspend fun addNote(vararg note: Note)

    @Query("SELECT * FROM notes")
    suspend fun getNotes(): List<Note>

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

}