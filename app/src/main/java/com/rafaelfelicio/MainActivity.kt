package com.rafaelfelicio

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var lvTitles: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //inicializando a listview
        lvTitles = findViewById(R.id.lv_titles)

        //titulos da listview
        val titles = arrayOf(
            "Fear of the Dark",
            "The Number of the Beast",
            "The Trooper",
            "Aces High",
            "Ghost of Navigator",
            "Run to the Hills",
            "Wasted years",
            "Phantom of the Opera"
        )

        //adapter da listview
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, titles)
        lvTitles.adapter = adapter

        //No evento do tap, passo o valor com o nome da musica para a intent e chamo a proxima activity
        lvTitles.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                val itemValue = lvTitles.getItemAtPosition(position) as String
                val intent = Intent(this@MainActivity, ShowLyricsActivity::class.java)
                intent.putExtra("title", itemValue)
                startActivity(intent)
            }
        }
    }
}
