package com.androiddinemapapp.dinemap.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.androiddinemapapp.dinemap.R
import com.androiddinemapapp.dinemap.buscar.BuscarFragment
import com.androiddinemapapp.dinemap.home.HomeFragment
import com.androiddinemapapp.dinemap.perfil.PerfilFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val navigationBottom = findViewById<BottomNavigationView>(R.id.navigationBottom)

        if(savedInstanceState == null) {
            navigationBottom.selectedItemId = R.id.itemHome
            openFragment(HomeFragment.NewInstance())
        }

        navigationBottom.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.itemHome -> {
                    val fragment = HomeFragment.NewInstance()
                    openFragment(fragment)
                    true
                }

                R.id.itemBuscar ->{
                    val fragment = BuscarFragment.NewInstance()
                    openFragment(fragment)
                    true
                }

                R.id.itemPerfil ->{
                    val fragment = PerfilFragment.NewInstance()
                    openFragment(fragment)
                    true
                }

                else -> false
            }
        }
    }






    fun openFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment, fragment)
        transaction.commit()
    }



}