package com.example.tp3fundamentos

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tp3fundamentos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvMetodologia.setOnClickListener {
            val uri = Uri.parse("https://www.bancopaulista.com.br/Arquivos/QuestionarioAPI.pdf")
            startActivity(Intent(Intent.ACTION_VIEW, uri))
        }

        binding.btnIniciarTeste.setOnClickListener {

            val nome = binding.editNome.text.toString()

            Intent(this, QuestionarioActivity::class.java).also {
                it.putExtra(NOME, nome)
                startActivity(it)
            }
        }
    }

    companion object {
        const val NOME = "nome"
    }

}