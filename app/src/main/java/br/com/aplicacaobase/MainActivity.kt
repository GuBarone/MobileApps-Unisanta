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
        val edtTensao = findViewById<EditText>(R.id.edtTensao)
        val edtResistencia = findViewById<EditText>(R.id.edtResistencia)
        val edtCorrente = findViewById<EditText>(R.id.edtCorrente)
        val txvResult = findViewById<TextView>(R.id.txvResult)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        btnCalcular.setOnClickListener {
            val tensao = edtTensao.text.toString().toFloatOrNull()
            val resistencia = edtResistencia.text.toString().toFloatOrNull()
            val corrente = edtCorrente.text.toString().toFloatOrNull()

            // 1º Caso: Faltou a Tensão (V) -> Calcula V = R * I
            if (tensao == null && resistencia != null && corrente != null) {
                val resultado = resistencia * corrente
                txvResult.text = "Tensão calculada: $resultado V"
            }
            // 2º Caso: Faltou a Resistência (R) -> Calcula R = V / I
            else if (resistencia == null && tensao != null && corrente != null) {
                if (corrente == 0f) {
                    txvResult.text = "Erro: A corrente não pode ser zero."
                    return@setOnClickListener
                }
                val resultado = tensao / corrente
                txvResult.text = "Resistência calculada: $resultado Ω"
            }
            // 3º Caso: Faltou a Corrente (I) -> Calcula I = V / R
            else if (corrente == null && tensao != null && resistencia != null) {
                if (resistencia == 0f) {
                    txvResult.text = "Erro: A resistência não pode ser zero."
                    return@setOnClickListener
                }
                val resultado = tensao / resistencia
                txvResult.text = "Corrente calculada: $resultado A"
            }
            // 4º Caso: Tratamento de Erros (Preencheu tudo, ou menos de 2 campos)
            else {
                txvResult.text = "Erro: Pelo menos 2 campos devem apresentar valor."
            }
        }
    }
}