package com.androiddinemapapp.dinemap.Login

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.androiddinemapapp.dinemap.R
import com.bumptech.glide.Glide

class RegisterActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val imgGif = findViewById<ImageView>(R.id.gifImage)

        Glide.with(this)
            .asGif()
            .load(R.drawable.gif_1)
            .into(imgGif)
    }
}