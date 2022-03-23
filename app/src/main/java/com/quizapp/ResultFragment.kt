package com.quizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.quizapp.databinding.FragmentResultBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class ResultFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentResultBinding.inflate(inflater, container, false)




        val bundle = arguments
        val UserName = bundle!!.getSerializable(Constants.USER_NAME) as String?
        var totalQuestions = bundle!!.getSerializable(Constants.TOTAL_QUESTIONS) as Int?
        var correctAnswers = bundle!!.getSerializable(Constants.CORRECT_ANSWERS) as Int?

        binding.tvName.text = UserName

        binding.tvScore.text = "Your Score is $correctAnswers out of $totalQuestions."


        binding.btnFinish.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_resultFragment_to_titleFragment)
        }

        return binding.root
    }
}