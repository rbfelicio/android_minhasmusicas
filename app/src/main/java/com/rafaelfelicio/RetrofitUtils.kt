package com.rafaelfelicio

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Classe responsavel pelas chamadas HTTP utilizando o Retrofit
 */
class RetrofitUtils {

    companion object{
        /**
         * Retorna o client retrofit para realizar as requisicoes da API
         */
        fun getRetrofitInstance(path : String) : Retrofit {
            return Retrofit.Builder().baseUrl(path).addConverterFactory(GsonConverterFactory.create()).build()
        }
    }
}