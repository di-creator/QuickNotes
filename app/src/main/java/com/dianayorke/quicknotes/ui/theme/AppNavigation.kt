package com.dianayorke.quicknotes.ui.theme

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dianayorke.quicknotes.screens.AddNoteScreen
import com.dianayorke.quicknotes.screens.NoteListScreen


@Composable
fun AppNavigation(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.NoteListRoute
    ){
        composable(Routes.NoteListRoute){
            NoteListScreen(navController)
        }
        composable(Routes.AddNoteRoute){
            AddNoteScreen(navController)
        }
    }
}

object Routes{
    const val NoteListRoute = "note-list"
    const val AddNoteRoute = "add-note"
}