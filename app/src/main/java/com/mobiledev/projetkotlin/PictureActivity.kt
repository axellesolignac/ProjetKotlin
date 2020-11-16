package com.mobiledev.projetkotlin

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

/*Configuration de l'action button search + Affichage de l'image cherchée*/

class PictureActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture)

        val searchButton = findViewById<Button>(R.id.search)
        val searchContent = findViewById<EditText>(R.id.searchZone).text

        val apibing = APIBing()

        searchButton.setOnClickListener {
            if (searchContent.isEmpty()) {
                Toast.makeText(this, "La zone de recherche est vide", Toast.LENGTH_LONG).show()
            } else {
                GlobalScope.async {
                    val response = apibing.response(searchContent)

                    launch {
                        println("async terminé")
                        println("response : $response")
                        displayImage(response)
                    }
                }
            }
        }
    }

    private fun displayImage(url: String?) {
        println("url : $url")
        println("************")
        var newUrl: URL = URL(url)
        var connection: HttpURLConnection = newUrl.openConnection() as HttpURLConnection
        connection.setDoInput(true)
        connection.connect()
        var input: InputStream = connection.getInputStream()
        var myBitmap: Bitmap = BitmapFactory.decodeStream(input)
        findViewById<ImageView>(R.id.imageview2).setImageBitmap(myBitmap)
        findViewById<ImageView>(R.id.imageview2).invalidate()
    }
}
