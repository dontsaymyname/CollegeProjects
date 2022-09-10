package com.example.tp3fundamentos

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.tp3fundamentos.databinding.FragmentQuestao3Binding

class Questao3Fragment : Fragment() {

    private var _binding: FragmentQuestao3Binding? = null
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

        _binding = FragmentQuestao3Binding.inflate(inflater, container, false)
        binding.run {
            btnConfirmarQ3.setOnClickListener {
                if (rgQ3.checkedRadioButtonId != -1) {

                    when (rgQ3.checkedRadioButtonId) {
                        R.id.rb_q3_item_a -> selecionarResposta(0, rbQ3ItemA.text.toString())
                        R.id.rb_q3_item_b -> selecionarResposta(1, rbQ3ItemB.text.toString())
                        R.id.rb_q3_item_c -> selecionarResposta(2, rbQ3ItemC.text.toString())
                        R.id.rb_q3_item_d -> selecionarResposta(4, rbQ3ItemD.text.toString())

                    }

                    root.findNavController()
                        .navigate(R.id.action_questao3Fragment_to_questao4Fragment)

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