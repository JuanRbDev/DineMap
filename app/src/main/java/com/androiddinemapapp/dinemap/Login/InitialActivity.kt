package com.androiddinemapapp.dinemap.Login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.androiddinemapapp.dinemap.R
import com.androiddinemapapp.dinemap.main.MainActivity
import com.bumptech.glide.Glide
import com.google.android.material.animation.AnimationUtils
import com.google.android.material.button.MaterialButton

class InitialActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_initial)

        val textos = arrayOf("Zendrix is Gay!",
            "Que haces tocandome puto", "Rarwwwwww...",
            "Oni-chan!!!!",
            "Inicia Sesion o Registrate si quieres comerme... digo comer",
            "Gracias por descargar la app, me ayuda para comer :3")


        val btnLogin = findViewById<MaterialButton>(R.id.btnLogin)
        val btnRegister = findViewById<MaterialButton>(R.id.btnRegister)

        val imgGif = findViewById<ImageView>(R.id.gifImage)
        val pantallaOscura = findViewById<FrameLayout>(R.id.pantallaOscura)
        val gifGrande = findViewById<ImageView>(R.id.gifGrande)
        val globoTexto = findViewById<TextView>(R.id.globoTexto)

        val animation = android.view.animation.AnimationUtils.loadAnimation(this, R.anim.flotar)


        Glide.with(this)
            .asGif()
            .load(R.drawable.gif_1)
            .into(imgGif)

        imgGif.setOnClickListener{
            val textoAleatorio = textos.random()

            pantallaOscura.visibility = View.VISIBLE
            globoTexto.startAnimation(animation)

            Glide.with(this)
                .asGif()
                .load(R.drawable.gif_1)
                .into(gifGrande)

            globoTexto.text = textoAleatorio
            pantallaOscura.setOnClickListener{
                pantallaOscura.visibility = View.GONE
            }
        }

        btnRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
}