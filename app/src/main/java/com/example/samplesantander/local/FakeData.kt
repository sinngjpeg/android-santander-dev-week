package com.example.samplesantander.local

import com.example.samplesantander.data.Cartao
import com.example.samplesantander.data.Cliente
import com.example.samplesantander.data.Conta

class FakeData {
    fun getLocalData(): Conta {
        val cliente = Cliente("Ingrid")
        val cartao = Cartao("4125455854")
        val conta = Conta(
            "4456555-7",
            "420-8",
            "R$ 450,00",
            "4.2450,00",
            cliente,
            cartao
        )
        return conta
    }
}