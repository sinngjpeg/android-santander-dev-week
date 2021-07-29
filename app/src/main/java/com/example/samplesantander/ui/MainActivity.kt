package com.example.samplesantander.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.samplesantander.R

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.buscarContaCliente().observe(this, Observer { result ->
            findViewById<TextView>(R.id.tv_agencia).text = result.agencia
            findViewById<TextView>(R.id.tv_conta_corrente).text = result.numero
            findViewById<TextView>(R.id.txt_valor_saldo).text = result.saldo
            findViewById<TextView>(R.id.tv_limite).text = result.limite
            findViewById<TextView>(R.id.tv_usuario).text = result.cliente.nome
            findViewById<TextView>(R.id.txt_cartao_numero).text = result.cartao.numeroFinal
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_1 -> {
                Log.d("CLICK", "Click no Item 1")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}