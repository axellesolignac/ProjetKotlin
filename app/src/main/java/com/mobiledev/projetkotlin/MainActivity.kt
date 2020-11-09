package com.mobiledev.projetkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater = menuInflater
        inflater.inflate(R.menu.menu_item, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.Share -> {
                Toast.makeText(this,"Shared ...", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.Liste -> {
                val intent = Intent(this, ListeActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.Jeux -> {
                return true
            }
            R.id.Quiz -> {
                val intent = Intent(this, QuizPageActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.MagicPic -> {
                Toast.makeText(this,"Baptiste ...", Toast.LENGTH_LONG).show()
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }
}