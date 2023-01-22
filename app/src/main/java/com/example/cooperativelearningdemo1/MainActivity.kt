package com.example.cooperativelearningdemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

class MainActivity : AppCompatActivity() {

    //Initializing our class scoped variables.
    private lateinit var ourImageView: ImageView
    private lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Setting our class scope variables to equal the ID we gave them in activity_main.xml.
        ourImageView = findViewById(R.id.ImageView)
        nextButton = findViewById(R.id.nextButton)

        //Sets the on click event listener to run the fetchImage function.
        nextButton.setOnClickListener {fetchImage()}
    }

    //Using volley and glide to get an img from a json body with an img URL.
/*    private fun fetchImage(){
        //You must create a queue that determines the priority of requests with volley.
        val volleyQueue = Volley.newRequestQueue(this)
        val apiUrl = "https://dog.ceo/api/breeds/image/random"

        //Creating the actual http request, with a json body its default is POST, else GET.
        val jsonObjectRequest = JsonObjectRequest(
            apiUrl,
            //What we do with the response.
            { response ->
                val imgUrl = response.get("message")
                Glide.with(this).load(imgUrl).into(ourImageView)
            },
            //What we do with an error.
            { error ->
                Log.e("MainActivity.kt", "Something went wrong with loading the image: ${error.localizedMessage}")
            }
        )
        //Finally we add it to our queue.
        volleyQueue.add(jsonObjectRequest)
    }*/

    //Using just glide to get an img when we already know the url.
    private fun fetchImage(){
        val url = "https://picsum.photos/200/300"
        Glide.with(this)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .skipMemoryCache(true)
            .into(ourImageView)

    }
}