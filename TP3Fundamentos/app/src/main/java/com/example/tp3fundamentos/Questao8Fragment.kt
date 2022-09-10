package com.example.tp3fundamentos

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.tp3fundamentos.databinding.FragmentQuestao8Binding


class Questao8Fragment : Fragment() {

    private var _binding: FragmentQuestao8Binding? = null
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

        _binding = FragmentQuestao8Binding.inflate(inflater, container, false)
        binding.run {
            btnConfirmarQ8.setOnClickListener {
                if (rgQ8.checkedRadioButtonId != -1) {

                    when (rgQ8.checkedRadioButtonId) {
                        R.id.rb_q8_item_a -> selecionarResposta(0, rbQ8ItemA.text.toString())
                        R.id.rb_q8_item_b -> selecionarResposta(1, rbQ8ItemB.text.toString())
                        R.id.rb_q8_item_c -> selecionarResposta(2, rbQ8ItemC.text.toString())
                        R.id.rb_q8_item_d -> selecionarResposta(4, rbQ8ItemD.text.toString())

                    }

                    root.findNavController()
                        .navigate(R.id.action_questao8Fragment_to_questao9Fragment)

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