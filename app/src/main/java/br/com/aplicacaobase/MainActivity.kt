package br.com.aplicacaobase

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val edtTemp = findViewById<EditText>(R.id.edtTemperatura)
        val txvResult = findViewById<TextView>(R.id.txvResult)
        val btnConverter = findViewById<Button>(R.id.btnConverter)
        btnConverter.setOnClickListener {
            val tempC = edtTemp.text.toString().toFloatOrNull()
            if (tempC != null){
                val tempF = (tempC * 1.8) + 32
                txvResult.text = "Temperatura em Fahrenheit: $tempF"
            }
            else
            {
                txvResult.text = "O campo \'Temperatura Celsius\' deve ser numérico."
            }
        }
    }
}