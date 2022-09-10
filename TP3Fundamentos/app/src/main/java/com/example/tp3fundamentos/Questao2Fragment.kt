package com.example.tp3fundamentos

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.tp3fundamentos.databinding.FragmentQuestao1Binding
import com.example.tp3fundamentos.databinding.FragmentQuestao2Binding

class Questao2Fragment : Fragment() {

    private var _binding: FragmentQuestao2Binding? = null
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

        _binding = FragmentQuestao2Binding.inflate(inflater, container, false)
        binding.run {
            btnConfirmarQ2.setOnClickListener {

                if (rgQ2.checkedRadioButtonId != -1) {

                    when (rgQ2.checkedRadioButtonId) {
                        R.id.rb_q2_item_a -> selecionarResposta(0, rbQ2ItemA.text.toString())
                        R.id.rb_q2_item_b -> selecionarResposta(2, rbQ2ItemB.text.toString())
                        R.id.rb_q2_item_c -> selecionarResposta(4, rbQ2ItemC.text.toString())
                        R.id.rb_q2_item_d -> selecionarResposta(5, rbQ2ItemD.text.toString())

                    }

                    root.findNavController()
                        .navigate(R.id.action_questao2Fragment_to_questao3Fragment)

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