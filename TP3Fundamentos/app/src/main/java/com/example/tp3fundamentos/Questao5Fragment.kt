package com.example.tp3fundamentos

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.tp3fundamentos.databinding.FragmentQuestao5Binding


class Questao5Fragment : Fragment() {

    private var _binding: FragmentQuestao5Binding? = null
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

        _binding = FragmentQuestao5Binding.inflate(inflater, container, false)
        binding.run {
            btnConfirmarQ5.setOnClickListener {
                if (rgQ5.checkedRadioButtonId != -1) {

                    when (rgQ5.checkedRadioButtonId) {
                        R.id.rb_q5_item_a -> selecionarResposta(0, rbQ5ItemA.text.toString())
                        R.id.rb_q5_item_b -> selecionarResposta(2, rbQ5ItemB.text.toString())
                        R.id.rb_q5_item_c -> selecionarResposta(4, rbQ5ItemC.text.toString())

                    }

                    root.findNavController()
                        .navigate(R.id.action_questao5Fragment_to_questao6Fragment)

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