package com.example.tp3fundamentos

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.tp3fundamentos.databinding.FragmentQuestao1Binding


class Questao1Fragment : Fragment() {

    private var _binding: FragmentQuestao1Binding? = null
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
        _binding = FragmentQuestao1Binding.inflate(inflater, container, false)

        binding.run {
            btnConfirmarQ1.setOnClickListener {
                if (rgQ1.checkedRadioButtonId != -1) {

                    when (rgQ1.checkedRadioButtonId) {
                        R.id.rb_q1_item_a -> selecionarResposta(0, rbQ1ItemA.text.toString())
                        R.id.rb_q1_item_b -> selecionarResposta(2, rbQ1ItemB.text.toString())
                        R.id.rb_q1_item_c -> selecionarResposta(3, rbQ1ItemC.text.toString())
                        R.id.rb_q1_item_d -> selecionarResposta(4, rbQ1ItemD.text.toString())

                    }

                    root.findNavController()
                        .navigate(R.id.action_questao1Fragment_to_questao2Fragment)

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