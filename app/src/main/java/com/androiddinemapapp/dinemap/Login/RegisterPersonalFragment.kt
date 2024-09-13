package com.androiddinemapapp.dinemap.Login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.androiddinemapapp.dinemap.R
import com.google.android.material.textfield.TextInputEditText

class RegisterPersonalFragment: Fragment() {

    private lateinit var edtNombre: TextInputEditText
    private lateinit var edtApellido: TextInputEditText
    private lateinit var edtDNI: TextInputEditText
    private lateinit var edtCorreo: TextInputEditText
    private lateinit var edtPhone: TextInputEditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register_one, container, false)

        edtNombre = view.findViewById(R.id.edtNombre)
        edtApellido = view.findViewById(R.id.edtApellido)
        edtDNI = view.findViewById(R.id.edtdni)
        edtCorreo = view.findViewById(R.id.edtCorreo)
        edtPhone = view.findViewById(R.id.edtPhone)

        edtNombre.addTextChangedListener {

        }
        edtApellido.addTextChangedListener{

        }
        return view
    }



}