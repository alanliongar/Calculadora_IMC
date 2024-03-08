package com.comunidadedevspace.imc

import android.icu.text.BidiClassifier
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
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

        result = (String.format("%.2f", result)).replace(",",".",false).toFloat()
        val Classi: Int = when (result) {
            in 0.00f..18.49f -> R.string.class_1
            in 18.50f..24.99f -> R.string.class_2
            in 25.00f..29.99f -> R.string.class_3
            in 30.00f..34.99f -> R.string.class_4
            in 35.00f..39.99f -> R.string.class_5
            else -> R.string.class_6
        }
        tvClassificacao.text = getString(Classi)
        val classificacaoColor = when (Classi){
            R.string.class_1 -> R.color.blue
            R.string.class_2 -> R.color.green
            R.string.class_3 -> R.color.orange
            R.string.class_4 -> R.color.red_light
            R.string.class_5 -> R.color.orange_red
            R.string.class_6 -> R.color.super_red
            else -> R.color.black
        }
        tvClassificacao.setTextColor(ContextCompat.getColor(this,classificacaoColor))
    }
}