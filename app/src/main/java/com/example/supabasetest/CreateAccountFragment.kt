package com.example.supabasetest

import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton


class CreateAccountFragment : Fragment() {

    private lateinit var backButton:ImageButton
    private lateinit var showHideButton:Button
    private lateinit var passwordEditText:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.apply {
            backButton = findViewById(R.id.backButton)
            showHideButton = findViewById(R.id.showHideButton)
            passwordEditText = findViewById(R.id.passwordEditText)
        }
        backButton.setOnClickListener(OnBackClickListener)
        showHideButton.setOnClickListener(OnShowHideClickListener)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_account, container, false)
    }

    private val OnBackClickListener = OnClickListener{
        (activity as MainActivity).showFragment(SignUpFragment.newInstance())
    }

    private val OnShowHideClickListener = OnClickListener {
        if(passwordEditText.inputType==1){
            passwordEditText.inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD
        }else{
            passwordEditText.inputType = InputType.TYPE_CLASS_TEXT
        }
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            CreateAccountFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}