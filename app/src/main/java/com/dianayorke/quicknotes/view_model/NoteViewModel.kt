package com.dianayorke.quicknotes.view_model


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.dianayorke.quicknotes.models.Note
import com.dianayorke.quicknotes.room.AppDatabase

class NoteViewModel(var application: Application) : AndroidViewModel(application){
   fun saveNotes(title: String, content: String ){

      fun saveNote(title: String, content: String){
         val note = Note(
            title = title,
            content = content
         )

         db.noteDao().saveNote(note)
      }

   }
}