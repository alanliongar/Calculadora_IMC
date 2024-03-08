package com.comunidadedevspace.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val edtpeso = findViewById<TextInputEditText>(R.id.edt_peso)
        val edtaltura = findViewById<TextInputEditText>(R.id.edt_altura)
        val btnCalcular = findViewById<Button>(R.id.btn_calcular)
        val btnLimpar = findViewById<Button>(R.id.btn_limpar)

        btnCalcular.setOnClickListener {
            val altura = edtaltura.text.toString().toFloatOrNull()
            val peso = edtpeso.text.toString().toFloatOrNull()

            if (peso == null) {
                Snackbar.make(edtpeso, getString(R.string.pre_peso), Snackbar.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (altura == null) {
                Snackbar.make(edtaltura, getString(R.string.pre_altura), Snackbar.LENGTH_LONG).show()
                return@setOnClickListener
            }
            val resultado = (peso / (altura * altura))
            val intent = Intent(this, ResultActivity::class.java) //this = classe atual
            intent.putExtra(KEY_RESULT_IMC, resultado)
            startActivity(intent)
        }
        btnLimpar.setOnClickListener {
            edtpeso.setText("")
            edtaltura.setText("")
        }
    }
}