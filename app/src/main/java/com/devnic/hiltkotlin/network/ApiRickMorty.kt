package com.devnic.hiltkotlin.network

import com.devnic.hiltkotlin.model.ObjectRM
import retrofit2.Response
import retrofit2.http.GET

interface ApiRickMorty {
    @GET("character")
   suspend fun getAllCharacters(): Response<ObjectRM>
}