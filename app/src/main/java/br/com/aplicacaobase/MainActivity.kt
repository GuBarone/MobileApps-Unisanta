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
        val nome = findViewById<EditText>(R.id.edtNome)
        val idade = findViewById<EditText>(R.id.edtIdade)
        val msg = findViewById<TextView>(R.id.txvMsg)
        val enviar = findViewById<Button>(R.id.btnEnviar)
        enviar.setOnClickListener {
            if (nome.text.isBlank()) {
                msg.text = "O campo nome não pode ficar vazio."
                return@setOnClickListener
            }
            val idadeInt = idade.text.toString().toIntOrNull()
            if (idadeInt == null || idadeInt < 0) {
                msg.text = "O campo idade está ausente ou inválido."
                return@setOnClickListener
            }
            msg.text = "Bem-vindo!\nNome: ${nome.text}\nIdade: $idadeInt"
        }
    }
}