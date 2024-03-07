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

        btnCalcular.setOnClickListener {
            //Ação do botão
            val altura = edtaltura.text.toString().toFloatOrNull()
            val peso = edtpeso.text.toString().toFloatOrNull()
            if (peso == null) {
                Snackbar.make(edtpeso, "Preencha o peso", Snackbar.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (altura == null) {
                Snackbar.make(edtaltura, "Preencha a altura", Snackbar.LENGTH_LONG).show()
                return@setOnClickListener
            }
            val resultado =
                (peso / (altura * altura)) //Coloquei o resultado aqui em baixo, pois precisamos garantir que as duas outras variáveis sejam não-null
            val intent = Intent(this, ResultActivity::class.java) //this = classe atual
            intent.putExtra(KEY_RESULT_IMC, resultado)
            startActivity(intent)
            //Cores
            //EditText background + icone
            //Gradiente + icone + titulo + descrição
        }
    }
}