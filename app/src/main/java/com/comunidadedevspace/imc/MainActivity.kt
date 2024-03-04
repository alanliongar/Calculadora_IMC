package com.comunidadedevspace.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Recuperar os componentes edittext
        //Criar uma variável e associar o componente de ui
        //Recuperar o botão da tela
        //colocar ação no botão
        //recuperar o texto digitado no peso

        val edtpeso = findViewById<TextInputEditText>(R.id.edt_peso).text
        val edtaltura = findViewById<TextInputEditText>(R.id.edt_altura).text
        val btnCalcular = findViewById<Button>(R.id.btn_calcular)
        btnCalcular.setOnClickListener {
            //Ação do botão
            val altura = edtaltura.toString().toFloatOrNull()
            val peso = edtpeso.toString().toFloatOrNull()
            val imc = if (peso != null && altura != null) peso / (altura * altura) else null
            println(imc)
        }
    }
}