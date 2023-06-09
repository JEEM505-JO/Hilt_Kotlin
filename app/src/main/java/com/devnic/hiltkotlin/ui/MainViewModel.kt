package com.devnic.hiltkotlin.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devnic.hiltkotlin.model.UiData
import com.devnic.hiltkotlin.repository.RepositoryRM
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: RepositoryRM
) : ViewModel() {
    private val _characters: MutableStateFlow<UiData> = MutableStateFlow(UiData(loading = false))
    val characters: StateFlow<UiData> = _characters.asStateFlow()

    fun getDataResult() = viewModelScope.launch(Dispatchers.IO) {
        _characters.update {
            it.copy(loading = true)
        }

        val result = repository.getCharacters()

        if (result.isSuccessful) {
            result.body()?.let { resultData ->
                _characters.update { uiData ->
                    uiData.copy(loading = false, listCharacters = resultData.result)
                }
            }
        }
    }

}