package com.example.tp3fundamentos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tp3fundamentos.databinding.ActivityQuestionarioBinding

class QuestionarioActivity : AppCompatActivity(), RespostasListener {

    private lateinit var binding: ActivityQuestionarioBinding

    var pontuacao = 0
    var nome = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionarioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        nome = intent.getStringExtra(MainActivity.NOME) ?: "void"
    }

    override fun onAnswerSubmit(pontos: Int) {
        pontuacao += pontos
    }

    override fun finishQuestions() {
        Intent(this, ResultadoActivity::class.java).also {
            it.putExtra(PONTUACAO, pontuacao)
            it.putExtra(MainActivity.NOME, nome)
            startActivity(it)
        }
    }

    companion object {
        const val PONTUACAO = "pontuacao"
    }

}