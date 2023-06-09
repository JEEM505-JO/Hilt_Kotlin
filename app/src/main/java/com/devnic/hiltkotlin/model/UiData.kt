package com.devnic.hiltkotlin.model

data class UiData(
    val loading: Boolean,
    val listCharacters: List<Characters> = listOf(),
)
