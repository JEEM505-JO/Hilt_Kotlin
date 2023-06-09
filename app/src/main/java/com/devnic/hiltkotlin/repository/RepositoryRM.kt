package com.devnic.hiltkotlin.repository

import com.devnic.hiltkotlin.network.ApiRickMorty
import javax.inject.Inject

class RepositoryRM @Inject constructor(private val api: ApiRickMorty) {

    suspend fun getCharacters() = api.getAllCharacters()

}