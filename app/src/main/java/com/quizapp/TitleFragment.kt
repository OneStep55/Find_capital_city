package com.quizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.quizapp.databinding.FragmentGameBinding
import com.quizapp.databinding.FragmentTitleBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class TitleFragment : Fragment() {

    private var _binding: FragmentTitleBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTitleBinding.inflate(inflater, container, false)
        val fragment = GameFragment();

        binding.btnStart.setOnClickListener {
            if (binding.etName.text.toString().isEmpty()) {

                Toast.makeText(context  ,"Please enter your name", Toast.LENGTH_SHORT).show()

            } else {


                val bundle = Bundle()
                bundle.putSerializable(Constants.USER_NAME, binding.etName.text.toString())
                view?.findNavController()?.navigate(R.id.action_titleFragment_to_gameFragment, bundle)
            }
        }

        return binding.root
    }


}