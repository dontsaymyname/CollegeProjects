package com.example.tp3fundamentos

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.tp3fundamentos.databinding.FragmentQuestao6Binding

class Questao6Fragment : Fragment() {

    private var _binding: FragmentQuestao6Binding? = null
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

        _binding = FragmentQuestao6Binding.inflate(inflater, container, false)
        binding.run {
            btnConfirmarQ6.setOnClickListener {
                if (rgQ6.checkedRadioButtonId != -1) {

                    when (rgQ6.checkedRadioButtonId) {
                        R.id.rb_q6_item_a -> selecionarResposta(0, rbQ6ItemA.text.toString())
                        R.id.rb_q6_item_b -> selecionarResposta(2, rbQ6ItemB.text.toString())
                        R.id.rb_q6_item_c -> selecionarResposta(3, rbQ6ItemC.text.toString())
                        R.id.rb_q6_item_d -> selecionarResposta(4, rbQ6ItemD.text.toString())

                    }

                    root.findNavController()
                        .navigate(R.id.action_questao6Fragment_to_questao7Fragment)

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