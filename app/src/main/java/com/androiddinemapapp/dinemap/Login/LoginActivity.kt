package com.androiddinemapapp.dinemap.Login

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.androiddinemapapp.dinemap.R
import com.androiddinemapapp.dinemap.main.MainActivity
import com.bumptech.glide.Glide
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import es.dmoral.toasty.Toasty
import org.w3c.dom.Text

class LoginActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val edtCorreo = findViewById<TextInputEditText>(R.id.edtCorreo)
        val edtPassword = findViewById<TextInputEditText>(R.id.edtPassword)
        val btnLogin = findViewById<MaterialButton>(R.id.btnLogin)

        val lytCorreo = findViewById<TextInputLayout>(R.id.lytCorreo)
        val lytPassword = findViewById<TextInputLayout>(R.id.lytPassword)

        btnLogin.setOnClickListener {
            val edtCorreoValue = edtCorreo.text.toString()
            val edtPasswordValue = edtPassword.text.toString()

            if(edtCorreoValue.isEmpty() && edtPasswordValue.isEmpty()){
                lytCorreo.error = "Ingrese su correo"
                lytPassword.error = "Ingrese su contraseña"
                Toasty.warning(this, "Complete los datos", Toasty.LENGTH_SHORT).show()
            }
            else if(edtPasswordValue.isEmpty()){
                lytCorreo.error = null
                lytPassword.error = "Ingrese su contraseña"
                Toasty.warning(this, "Falta completar datos", Toasty.LENGTH_SHORT).show()
            }
            else if(edtCorreoValue.isEmpty()){
                lytCorreo.error = "Ingrese su correo"
                lytPassword.error = null
                Toasty.warning(this, "Falta completar datos", Toasty.LENGTH_SHORT).show()
            }
            else if(edtCorreoValue.equals("enmanueldelaza@gmail.com") && edtPasswordValue.equals("12345")){
                lytCorreo.error = null
                lytPassword.error = null
                Toasty.success(this, "Inicio Sesion correctamente", Toasty.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            else{
                lytCorreo.error = "Correo incorrecto"
                lytPassword.error = "Contraseña incorrecta"
                Toasty.error(this, "Hubo un error", Toasty.LENGTH_SHORT).show()

            }

        }


    }
}