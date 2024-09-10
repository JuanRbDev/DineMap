package com.androiddinemapapp.dinemap.Login

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.androiddinemapapp.dinemap.R
import com.androiddinemapapp.dinemap.main.MainActivity
import com.bumptech.glide.Glide
import com.google.android.material.button.MaterialButton

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnLogin = findViewById<MaterialButton>(R.id.btnLogin)
        val imgGif = findViewById<ImageView>(R.id.gifImage)

        Glide.with(this)
            .asGif()
            .load(R.drawable.gif_1)
            .into(imgGif)

        btnLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
}