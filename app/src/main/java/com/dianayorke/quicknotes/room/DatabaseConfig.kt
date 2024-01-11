package com.dianayorke.quicknotes.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dianayorke.quicknotes.models.Note
import com.dianayorke.quicknotes.room.NoteDao

object DatabaseConfig {
    fun getInstance(context: Context): AppDatabase{
        var db = Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "note_db"
        ).build()
        return db
    }
}

@Database(entities = [Note::class], version = 1)
abstract class AppDatabase: RoomDatabase(){
    abstract fun noteDao(): NoteDao
}