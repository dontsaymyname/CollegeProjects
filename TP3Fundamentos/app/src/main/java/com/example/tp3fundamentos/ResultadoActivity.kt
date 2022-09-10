package com.example.tp3fundamentos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tp3fundamentos.databinding.ActivityResultadoBinding

class ResultadoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nome = intent.getStringExtra(MainActivity.NOME)
        val resultado = intent.getIntExtra(QuestionarioActivity.PONTUACAO, 0)

        binding.tvNome.text = nome
        binding.tvResultado.text = "Investidor: ${resultado.definirPerfil()}"
    }


    private fun Int.definirPerfil(): String {
        return when {
            this < 15 -> "Conservador"
            this > 35 -> "Arrojado"
            else -> "Moderado"
        }
    }
}