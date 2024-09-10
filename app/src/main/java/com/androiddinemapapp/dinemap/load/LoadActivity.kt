package com.androiddinemapapp.dinemap.load

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.androiddinemapapp.dinemap.Login.LoginActivity
import com.androiddinemapapp.dinemap.R
import com.androiddinemapapp.dinemap.main.MainActivity
import es.dmoral.toasty.Toasty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoadActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load)

        MetodoCarga()
    }

    private fun MetodoCarga(){
        CoroutineScope(Dispatchers.Main).launch{
            val internetActivo = withContext(Dispatchers.IO){
                AccesoInternet()
            }
            Handler(Looper.getMainLooper()).postDelayed({
                if(internetActivo){
                    val intent = Intent(this@LoadActivity, LoginActivity::class.java)
                    startActivity(intent)
                    overridePendingTransition(R.anim.desvanecimiento_entrada, R.anim.desvanecimiento_salida)
                    finish()
                }
                else{
                    Toasty.custom(this@LoadActivity, "No hay conexión a internet",
                        R.drawable.icon_error_internet, R.color.black, 3000, true, false).show()
                }
            },3000)
        }

    }

    private fun AccesoInternet():Boolean{
        val connectManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val red = connectManager.activeNetwork ?: return false
        val redActiva = connectManager.getNetworkCapabilities(red) ?: return false
        return when{
            redActiva.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            redActiva.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            else -> false
        }
    }
}