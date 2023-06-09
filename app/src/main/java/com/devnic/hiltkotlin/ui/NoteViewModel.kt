package com.devnic.hiltkotlin.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.devnic.hiltkotlin.database.StateUi
import com.devnic.hiltkotlin.model.modelbd.NoteModel
import com.devnic.hiltkotlin.repository.RepositoryNote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val repositoryNote: RepositoryNote) : ViewModel() {

    val listNote: LiveData<List<NoteModel>> = repositoryNote.noteList.asLiveData()
    val uiState: MutableStateFlow<StateUi> = MutableStateFlow(
        StateUi(
            insert = ::insertNote,
            onChangeResume = ::onChangeResume,
            onChangeTitle = ::onChangeTitle,
            setOnNavNoteList = ::setOnNavListNote
        )
    )

    private fun insertNote() {
        viewModelScope.launch(Dispatchers.IO) {
            val(title,resume) = uiState.value
            uiState.update {
                it.copy(loading = true, isSuccess = false)
            }
            try {
                repositoryNote.insertNote(NoteModel(title = title, resume = resume))
                uiState.update {
                    it.copy(isSuccess = true, loading = false)
                }
            } catch (e: Exception) {
                println(e.message.toString())
            }
        }
    }

    private fun onChangeTitle(value : String){
        viewModelScope.launch {
            uiState.update {
                it.copy(title = value)
            }
        }
    }

    private fun onChangeResume(value: String){
        viewModelScope.launch {
            uiState.update {
                it.copy(resume = value)
            }
        }
    }

    private fun setOnNavListNote(func : () -> Unit){
        viewModelScope.launch {
            uiState.update {
                it.copy(onNavNoteList = func)
            }
        }
    }

    fun deleteNote(noteModel: NoteModel) = viewModelScope.launch(Dispatchers.IO) {
        repositoryNote.deleteNote(noteModel)
    }
}