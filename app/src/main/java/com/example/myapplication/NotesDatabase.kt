package com.example.myapplication

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class] , version = 1)
abstract class NotesDatabase : RoomDatabase() {

    abstract fun getNoteDao (): NoteDao

    object DatabaseBuilder{
        fun getInstance(context: Context): NotesDatabase {
            val db = Room.databaseBuilder(
                context.applicationContext,
                NotesDatabase::class.java, "notes_db"
            ).build()
            return db
        }
    }

}