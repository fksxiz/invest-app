package com.example.supabasetest.View

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
import com.example.supabasetest.R
import com.google.android.material.button.MaterialButton


class CreateAccountFragment : Fragment() {

    private lateinit var backButton:ImageButton
    private lateinit var createButton:MaterialButton
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
            createButton = findViewById(R.id.createButton)
            showHideButton = findViewById(R.id.showHideButton)
            passwordEditText = findViewById(R.id.passwordEditText)
        }
        backButton.setOnClickListener(OnBackClickListener)
        showHideButton.setOnClickListener(OnShowHideClickListener)
        createButton.setOnClickListener(OnCreateClickListener)
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

    private val OnCreateClickListener = OnClickListener{
        (activity as MainActivity).showFragment(HomeFragment.newInstance())
    }

    private val OnShowHideClickListener = OnClickListener {
        if(passwordEditText.inputType==1){
            passwordEditText.inputType = 129
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