package com.devnic.hiltkotlin.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.devnic.hiltkotlin.database.StateUi
import com.devnic.hiltkotlin.navigation.Destinations.*
import com.devnic.hiltkotlin.ui.MainUi
import com.devnic.hiltkotlin.ui.NoteEdits
import com.devnic.hiltkotlin.ui.NoteList
import com.devnic.hiltkotlin.ui.NoteViewModel
import com.devnic.hiltkotlin.ui.RickAndMortyApi
import com.devnic.hiltkotlin.ui.TegnologiInfo

@Composable
fun NavigationHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = MainUi.route) {

        composable(MainUi.route) {
            MainUi(navController)
        }

        composable(RickMorty.route) {
            RickAndMortyApi()
        }
        composable(NotePads.route) {
            NoteList(navController)
        }

        composable(AddNote.route) {
            val viewMoNote: NoteViewModel = hiltViewModel()
            val state: StateUi by viewMoNote.uiState.collectAsState()
            state.setOnNavNoteList {
                    navController.navigate(NotePads.route)
            }
            NoteEdits(state = state)
        }

        composable(TegInfo.route) {
            TegnologiInfo()
        }
    }
}