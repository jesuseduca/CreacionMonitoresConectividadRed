package com.example.creacionmonitoresconectividadred

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {

    private lateinit var conexionInternet: TextView

    private val internetInfoReceiver = object : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val tipoConexion: String = intent.getStringExtra("conexion")
        conexionInternet.text = "El movil esta conectado a $tipoConexion"



    }
}
    

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        conexionInternet = findViewById<TextView>(R.id.textViewConexion)

        registerReceiver(internetInfoReceiver, IntentFilter(Intent.ACTION_MANAGE_NETWORK_USAGE))

        }
    }
