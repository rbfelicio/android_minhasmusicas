package com.rafaelfelicio

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ShowLyricsActivity : AppCompatActivity() {

    lateinit var tvLyrics: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_lyrics)
        var musicTitle = intent.getStringExtra("title").toString()
        tvLyrics = findViewById(R.id.tvLyrics)
        getData(musicTitle)
    }


    /**
     * Utilizando uma API publica de letras de musicas
     */
    fun getData(musicTitle : String) {
        val retrofitClient = RetrofitUtils.getRetrofitInstance("https://api.lyrics.ovh/v1/")
        val endpoint = retrofitClient.create(EndPoint::class.java)
        val callback = endpoint.getLyrics("Iron Maiden", musicTitle)

        callback.enqueue(object : Callback<Lyrics> {
            override fun onResponse(call: Call<Lyrics>, response: Response<Lyrics>) {
                tvLyrics.text = response.body()?.lyrics
            }

            override fun onFailure(call: Call<Lyrics>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
                tvLyrics.text = t.message;
            }
        })
    }
}