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

class RegisterActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val lytNombre = findViewById<TextInputLayout>(R.id.lytNombre)
        val lytApellido = findViewById<TextInputLayout>(R.id.lytApellido)
        val lytdni = findViewById<TextInputLayout>(R.id.lytdni)
        val lytCorreo = findViewById<TextInputLayout>(R.id.lytCorreo)
        val lytPhone = findViewById<TextInputLayout>(R.id.lytPhone)

        val edtNombre = findViewById<TextInputEditText>(R.id.edtNombre)
        val edtApellido = findViewById<TextInputEditText>(R.id.edtApellido)
        val edtdni = findViewById<TextInputEditText>(R.id.edtdni)
        val edtCorreo = findViewById<TextInputEditText>(R.id.edtCorreo)
        val edtPhone = findViewById<TextInputEditText>(R.id.edtPhone)

        val btnSiguiente = findViewById<MaterialButton>(R.id.btnSiguiente)

        val imgGif = findViewById<ImageView>(R.id.gifImage)

        btnSiguiente.setOnClickListener {
            val edtNombreValue = edtNombre.text.toString()
            val edtApellidoValue = edtApellido.text.toString()
            val edtdniValue = edtdni.text.toString()
            val edtCorreoValue = edtCorreo.text.toString()
            val edtPhoneValue = edtPhone.text.toString()

            if(edtNombreValue.isEmpty()
                && edtApellidoValue.isEmpty()
                && edtdniValue.isEmpty()
                && edtCorreoValue.isEmpty()
                && edtPhoneValue.isEmpty()){
                lytNombre.error = "Ingrese sus nombres"
                lytApellido.error = "Ingrese sus apellidos"
                lytdni.error = "Ingrese su DNI"
                lytCorreo.error = "Ingrese su correo"
                lytPhone.error = "Ingrese su número de celular"
                Toasty.warning(this, "Complete los datos", Toasty.LENGTH_SHORT).show()
            }
            else if(edtNombreValue.isEmpty()){
                lytNombre.error = "Ingrese sus nombres"
                lytApellido.error = null
                lytdni.error = null
                lytCorreo.error = null
                lytPhone.error = null
                Toasty.warning(this, "Falta completar datos", Toasty.LENGTH_SHORT).show()
            }
            else if(edtApellidoValue.isEmpty()){
                lytNombre.error = null
                lytApellido.error = "Ingrese sus apellidos"
                lytdni.error = null
                lytCorreo.error = null
                lytPhone.error = null
                Toasty.warning(this, "Falta completar datos", Toasty.LENGTH_SHORT).show()
            }
            else if(edtdniValue.isEmpty()){
                lytNombre.error = null
                lytApellido.error = null
                lytdni.error = "Ingrese su DNI"
                lytCorreo.error = null
                lytPhone.error = null
                Toasty.warning(this, "Falta completar datos", Toasty.LENGTH_SHORT).show()
            }
            else if(edtCorreoValue.isEmpty()){
                lytNombre.error = null
                lytApellido.error = null
                lytdni.error = null
                lytCorreo.error = "Ingrese su correo"
                lytPhone.error = null
                Toasty.warning(this, "Falta completar datos", Toasty.LENGTH_SHORT).show()
            }
            else if(edtdniValue.length > 8){
                lytNombre.error = null
                lytApellido.error = null
                lytdni.error = "Límite de carácteres: 8"
                lytCorreo.error = null
                lytPhone.error = null
            }
            else if(edtPhoneValue.length > 9){
                lytNombre.error = null
                lytApellido.error = null
                lytdni.error = null
                lytCorreo.error = null
                lytPhone.error = "Límite de carácteres: 9"
            }
            else if(edtNombreValue.equals("Javiercito Enmanuel")
                && edtApellidoValue.equals("De la Cruz Carranza")
                && edtdniValue.equals("71787555")
                && edtCorreoValue.equals("enmanueldelaza@gmail.com")
                && edtPhoneValue.isEmpty() || edtPhoneValue.equals("966863192")){
                lytNombre.error = null
                lytApellido.error = null
                lytdni.error = null
                lytCorreo.error = null
                lytPhone.error = null
                val intent = Intent(this, RegisterTwoActivity::class.java)
                startActivity(intent)
            }
            else{
                lytNombre.error = "Hubo un error"
                lytApellido.error = "Hubo un error"
                lytdni.error = "Hubo un error"
                lytCorreo.error = "Hubo un error"
                lytPhone.error = "Hubo un error"
                Toasty.error(this, "Hubo un error", Toasty.LENGTH_SHORT).show()
            }
        }

        Glide.with(this)
            .asGif()
            .load(R.drawable.gif_1)
            .into(imgGif)
    }
}