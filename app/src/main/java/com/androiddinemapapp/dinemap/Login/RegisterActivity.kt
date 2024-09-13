package com.androiddinemapapp.dinemap.Login

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.androiddinemapapp.dinemap.R
import com.androiddinemapapp.dinemap.main.MainActivity
import com.bumptech.glide.Glide
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import es.dmoral.toasty.Toasty

class RegisterActivity:AppCompatActivity() {
    private lateinit var btnSiguiente : MaterialButton
    private lateinit var btnAtras : MaterialButton
    private lateinit var Barraprogreso : ProgressBar

    private var RecorridoPasos = 0
    private var totalPasos = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnSiguiente = findViewById(R.id.btnSiguiente)
        btnAtras = findViewById(R.id.btnAtras)
        Barraprogreso = findViewById(R.id.progreso)

        cargarFragmento(0)

        btnAtras.isEnabled = false

        btnSiguiente.setOnClickListener {
            if(validarSiguientePaso()){
                RecorridoPasos++
                actualizarBarradeProgreso()
                cargarFragmento(RecorridoPasos)
            }
        }

        btnAtras.setOnClickListener {
            RecorridoPasos--
            actualizarBarradeProgreso()
            cargarFragmento(RecorridoPasos)
        }
    }
    private fun cargarFragmento(paso: Int){
        val fragment = when(paso){
            0 -> RegisterPersonalFragment()
            else -> throw IllegalArgumentException("El paso no existe")
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment, fragment)
            .commit()

        btnAtras.isEnabled = paso > 0
        btnSiguiente.isEnabled = paso < totalPasos - 1
    }

    private fun validarSiguientePaso() : Boolean{
        return true
    }

    private fun actualizarBarradeProgreso(){
        val progreso = ((RecorridoPasos + 1) * 100) / totalPasos
        Barraprogreso.progress = progreso
    }
}