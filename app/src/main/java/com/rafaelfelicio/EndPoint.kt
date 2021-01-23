package com.rafaelfelicio

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Interface para funcoes do Endpoint
 */
interface EndPoint {

    /**
     * Recebe o nome do artista e titulo da musica
     */
    @GET("{artist}/{title}")
    fun getLyrics(@Path("artist") artist: String,
                  @Path("title") title: String): Call<Lyrics>
}