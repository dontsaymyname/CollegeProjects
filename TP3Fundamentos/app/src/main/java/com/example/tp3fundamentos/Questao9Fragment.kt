package com.example.tp3fundamentos

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.tp3fundamentos.databinding.FragmentQuestao9Binding

class Questao9Fragment : Fragment() {

    private var _binding: FragmentQuestao9Binding? = null
    private val binding get() = _binding!!

    private lateinit var respostasListener: RespostasListener

    override fun onAttach(context: Context) {
        if (context is RespostasListener) {
            respostasListener = context
        }
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentQuestao9Binding.inflate(inflater, container, false)
        binding.run {
            btnConfirmarQ9.setOnClickListener {
                if (rgQ9.checkedRadioButtonId != -1) {

                    when (rgQ9.checkedRadioButtonId) {
                        R.id.rb_q9_item_a -> selecionarResposta(0, rbQ9ItemA.text.toString())
                        R.id.rb_q9_item_b -> selecionarResposta(1, rbQ9ItemB.text.toString())
                        R.id.rb_q9_item_c -> selecionarResposta(2, rbQ9ItemC.text.toString())
                        R.id.rb_q9_item_d -> selecionarResposta(4, rbQ9ItemD.text.toString())
                        R.id.rb_q9_item_e -> selecionarResposta(5, rbQ9ItemE.text.toString())

                    }

                    respostasListener.finishQuestions()

                } else {
                    Toast.makeText(
                        context,
                        "Por favor, selecione uma alternativa",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
        return binding.root
    }

    private fun selecionarResposta(pontos: Int, resposta: String) {
        respostasListener.onAnswerSubmit(pontos)
        Toast.makeText(context, "Você selecionou: $resposta ", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}