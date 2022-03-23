package com.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import com.quizapp.databinding.FragmentGameBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class GameFragment : Fragment() {

    private var mCurrentPosition:Int = 1;
    private var mQuestionsList:ArrayList<Question>? = null
    private var mSelectedOptionPosition : Int = 1
    private var mCorrectAnswers : Int = 0;
    private var mUserName: String? = null
    private var buttonIsSelected: Boolean = false
    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentGameBinding.inflate(inflater, container, false )
        mQuestionsList = Constants.getQuestions()

        setQuestion()
        val bundle = arguments
        mUserName = bundle!!.getSerializable(Constants.USER_NAME) as String?
        binding.tvOptionOne.setOnClickListener {
            selectedOptionView(binding.tvOptionOne, 1)
        }

        binding.tvOptionTwo.setOnClickListener{
            selectedOptionView(binding.tvOptionTwo, 2)
        }
        binding.tvOptionThree.setOnClickListener {
            selectedOptionView(binding.tvOptionThree, 3)
        }
        binding.tvOptionFour.setOnClickListener {
            selectedOptionView(binding.tvOptionFour, 4)
        }
        binding.btnSubmit.setOnClickListener {
            if(mSelectedOptionPosition == 0) {

                mCurrentPosition++

                when{
                    mCurrentPosition <= mQuestionsList!!.size -> {
                        setQuestion()
                    } else -> {

                    val bundle = Bundle()
                    bundle.putSerializable(Constants.USER_NAME, mUserName)
                    bundle.putSerializable(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                    bundle.putSerializable(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size)
                    view?.findNavController()?.navigate(R.id.action_gameFragment_to_resultFragment, bundle)
                }
                }
            } else {
                val question = mQuestionsList?.get(mCurrentPosition - 1)
                if(question!!.correctAnswer != mSelectedOptionPosition) {
                    answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                } else {
                    mCorrectAnswers++;
                }
                answerView(question.correctAnswer, R.drawable.correct_option_border_bg)
                if(mCurrentPosition == mQuestionsList!!.size) {
                    binding.btnSubmit.text = "FINISH"
                } else {
                    binding.btnSubmit.text = "GO TO NEXT QUESTION"
                }

                mSelectedOptionPosition = 0;
            }
        }
        return binding.root
    }

    private fun setQuestion(){
        val question = mQuestionsList!![mCurrentPosition-1]

        defaultOptionsView()

        buttonIsSelected = false;
        if(mCurrentPosition == mQuestionsList!!.size) {

            binding.btnSubmit.text = "FINISH"
        } else {
            binding.btnSubmit.text = "Submit"
        }
        binding.progressBar.progress = mCurrentPosition
        binding.tvProgress.text = "$mCurrentPosition" + "/" + binding.progressBar.max




        binding.tvQuestion.text = question!!.question;

        binding.tvOptionOne.text = question.optionOne
        binding.tvOptionTwo.text = question.optionTwo
        binding.tvOptionThree.text = question.optionThree
        binding.tvOptionFour.text = question.optionFour
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        options.add(0, binding.tvOptionOne)
        options.add(1, binding.tvOptionTwo)
        options.add(2, binding.tvOptionThree)
        options.add(3, binding.tvOptionFour)

        for(option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = activity?.let {
                ContextCompat.getDrawable(
                    it,
                    R.drawable.default_option_border_bg
                )
            }
        }
    }



    private fun answerView(answer: Int, drawableView: Int) {
        buttonIsSelected = true;
        when(answer) {
            1 ->{
                binding.tvOptionOne.background = activity?.let {
                    ContextCompat.getDrawable(
                        it, drawableView
                    )
                }
            }
            2 ->{
                binding.tvOptionTwo.background = activity?.let {
                    ContextCompat.getDrawable(
                        it, drawableView
                    )
                }
            }
            3 ->{
                binding.tvOptionThree.background = activity?.let {
                    ContextCompat.getDrawable(
                        it, drawableView
                    )
                }
            }
            4 ->{
                binding.tvOptionFour.background = activity?.let {
                    ContextCompat.getDrawable(
                        it, drawableView
                    )
                }
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum : Int ) {
        if(!buttonIsSelected) {
            defaultOptionsView()
            mSelectedOptionPosition = selectedOptionNum
            tv.setTextColor(Color.parseColor("#363A43"))
            tv.setTypeface(tv.typeface, Typeface.BOLD)
            tv.background = activity?.let {
                ContextCompat.getDrawable(
                    it,
                    R.drawable.selected_option_border_bg
                )
            }
        }
    }




}






