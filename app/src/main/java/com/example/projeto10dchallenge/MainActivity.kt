package com.example.projeto10dchallenge

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.isDigitsOnly

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalculate : Button = findViewById(R.id.btnCalculate)
        val edtPeso : EditText = findViewById(R.id.edittext_peso)
        val edtAltura : EditText = findViewById(R.id.edittext_altura)

        btnCalculate.setOnClickListener {

            val alturaStr = edtAltura.text.toString()
            val pesoStr = edtPeso.text.toString()

            if (alturaStr.isNotEmpty() && pesoStr.isNotEmpty()){
                val altura: Float = alturaStr.toFloat()
                val alturaFinal: Float = altura * altura

                val peso: Float = pesoStr.toFloat()
                val result = peso / alturaFinal

                 val intent = Intent(this, ResultMainActivity::class.java)
                    .apply {
                         putExtra( "EXTRA_RESULT",result)
                    }
                startActivity(intent)

            } else {
                    Toast.makeText(this,"preencher todos os campos", Toast.LENGTH_LONG).show()
            }
        }
    }

}