package com.dianayorke.quicknotes.screens


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.dianayorke.quicknotes.componets.NoteItem
import com.dianayorke.quicknotes.ui.theme.AppNavigation
import com.dianayorke.quicknotes.ui.theme.Routes
import com.dianayorke.quicknotes.view_model.NoteViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteListScreen(navController: NavController){
    val nViewModel: NoteViewModel = viewModel()
    val listOfNotes by nViewModel.getAllNotes().observeAsState(emptyList())

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text="WTM Note App") },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White,
                    actionIconContentColor = Color.White
                ),
                actions = {
                    IconButton(onClick = {}){
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search for note"
                        )
                    }
                    IconButton(onClick = {}){
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = "More Icon"
                        )
                    }
                }
            )
        },
        content = {paddingValues ->
            LazyColumn(
                modifier= Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
            ) {
                //Note Items WIll be here
                items(listOfNotes){
                    NoteItem()
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate(Routes.AddNoteRoute) }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add New Note"
                )
            }
        }
    )
}

@Preview
@Composable
fun NoteListScreenPreview(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        AppNavigation()
    }
}