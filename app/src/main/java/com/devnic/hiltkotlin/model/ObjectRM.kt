package com.devnic.hiltkotlin.model

import com.google.gson.annotations.SerializedName

data class ObjectRM(
    @SerializedName("info")
    val info: InfoRM,
    @SerializedName("results")
    val result: List<Characters>
)
