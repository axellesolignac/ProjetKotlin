package com.mobiledev.projetkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random.Default.nextInt

/* Affichage de la liste et création des items
* Recycler View ne marche pas meme en rajoutant le plugin "apply plugin: 'kotlin-android-extensions'"*/


class ListeActivity : AppCompatActivity() {

    private val exampleList = generateDummyList(500)
    /*private val adapter = ListAdapter(exampleList)*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_liste)
        val recycler_view: RecyclerView = findViewById(R.id.recycler_view)
        /*recycler_view.adapter = adapter*/
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)
    }

    private fun generateDummyList(size: Int): ArrayList<List> {
        val list = ArrayList<List>()
        for (i in 0 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.ic_list
                1 -> R.drawable.ic_action_copy
                else -> R.drawable.ic_action_share
            }
            val item = List(drawable, "Item $i", "Line 2")
            list += item
        }
        return list
    }
}