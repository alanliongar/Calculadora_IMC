package com.comunidadedevspace.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
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

        val edtpeso = findViewById<TextInputEditText>(R.id.edt_peso)
        val edtaltura = findViewById<TextInputEditText>(R.id.edt_altura)
        val btnCalcular = findViewById<Button>(R.id.btn_calcular)


        btnCalcular.setOnClickListener {
            //Ação do botão
            val altura = edtaltura.text.toString().toFloatOrNull()
            val peso = edtpeso.text.toString().toFloatOrNull()

            if (peso == null) {
                println("Peso está vazio")
                Snackbar.make(edtpeso, "Preencha o peso", Snackbar.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (altura == null) {
                println("Altura está vazia")
                Snackbar.make(edtaltura, "Preencha a altura", Snackbar.LENGTH_LONG).show()
                return@setOnClickListener
            }

            println(peso / (altura * altura))
        }
            //o código abaixo serviu para outro aprendizado, uso de if numa linha só, por exemplo...
            //val altura = edtaltura.toString().toFloatOrNull()
            //val peso = edtpeso.toString().toFloatOrNull()
            //val imc = if (peso != null && altura != null) peso / (altura * altura) else null
            //if (imc == null) println ("Esta vazio") else println(imc)
        }
    //Criar o screenshot do app rodando, com o snackbar (ambas as opções).
    }