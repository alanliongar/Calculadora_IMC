package com.comunidadedevspace.imc

import android.icu.text.BidiClassifier
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        var result = intent.getFloatExtra(KEY_RESULT_IMC, 0f)
        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)
        tvResult.text = String.format("%.2f", result)
        //tvResult.text = result.toString()
        result = (String.format("%.2f", result)).replace(",",".",false).toFloat()
        val Classi: String = if (result < 18.50) {
            "Abaixo do peso" //Azul claro
        } else if (result >= 18.50 && result < 25.00) {
            "Peso normal" //Verde mediano
        } else if (result >= 25.00 && result < 30.00) {
            "Sobrepeso" //Vermelho clarinho
        } else if (result >= 30.00 && result < 35.00) {
            "Obesidade grau I" //Laranja
        } else if (result >= 35.00 && result < 40.00) {
            "Obesidade grau II" //Laranja pra vermelho
        } else {
            "Obesidade grau III" //Vermelho escurão
        }
        tvClassificacao.text = Classi
        //Tarefinha pra casa
        //Criar a cor dinamica
        //Criar o "70% abaixo e 30% acima" no textview da tela de resultado
        //Criar o botão de limpar os dados, na primeira tela
    }
}