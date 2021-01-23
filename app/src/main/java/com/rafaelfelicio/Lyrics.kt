package com.rafaelfelicio

import com.google.gson.annotations.SerializedName

/**
 * Data Class que servira como "model" serializando o objeto de retorno da API
 */
data class Lyrics(

    @SerializedName("lyrics")
    var lyrics: String
)

