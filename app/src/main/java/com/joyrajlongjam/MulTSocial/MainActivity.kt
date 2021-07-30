package com.joyrajlongjam.MulTSocial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    var currentImageUrl:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadMeme()
    }

 private fun loadMeme(){
     val queue = Volley.newRequestQueue(this)
     val url = "https://meme-api.herokuapp.com/gimme"

     val jsonObjectRequest= JsonObjectRequest(
         Request.Method.GET, url,null,
         { response ->
            // Log.d("Success Request",response.substring(0,500))
              currentImageUrl=response.getString("url")
         //   ImageView memeImageView=(ImageView)findViewby
            Glide.with(this).load(currentImageUrl).into(findViewById(R.id.memeImageView))
         }
     ) {
         Toast.makeText(this, "Something Wrong", Toast.LENGTH_LONG).show()
         //  Log.d("error",it.localizedMessage)
     }

     queue.add(jsonObjectRequest)
}
    fun shareMeme(view: View) {
val intent=Intent(Intent.ACTION_SEND)
      intent.type="text/plain"
        intent.putExtra(Intent.EXTRA_TEXT,"Checkout this cool meme:) $currentImageUrl")
        val chooser=Intent.createChooser(intent,"Share this meme using...")
        startActivity(chooser)


    }
    fun nextMeme(view: View) {
        loadMeme()


    }
}