package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivity : ComponentActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var notesAdapter: NotesAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        // SOLID   Single responsibility

        lifecycleScope.launch(Dispatchers.IO) {
            val dao = NotesDatabase.DatabaseBuilder.getInstance(this@MainActivity).getNoteDao()
            //dao.addNote(Note(0,"To-do list","Reply to emails, prepare presentation slides for the marketing meeting, conduct research on competitor products, schedule and plan customer interviews, take a break and recharge."))
            val notesList = dao.getNotes()

            withContext(Dispatchers.Main){
                val notesAdapter = NotesAdapter(notesList)
                binding.rvNotes.adapter=notesAdapter
            }
        }



    }
}
