package com.example.supabasetest.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.TextView
import com.example.supabasetest.R
import com.google.android.material.button.MaterialButton


class SignUpFragment : Fragment() {


    private lateinit var createButton: MaterialButton
    private lateinit var loginButton: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.apply {
            createButton = findViewById(R.id.createButton)
            loginButton = findViewById(R.id.textView)
        }
        createButton.setOnClickListener(OnCreateClickListener)
    }

    private val OnCreateClickListener = OnClickListener{
        (activity as MainActivity).showFragment(CreateAccountFragment.newInstance())
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            SignUpFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}