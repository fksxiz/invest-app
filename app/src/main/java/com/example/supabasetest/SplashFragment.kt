package com.example.supabasetest

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.util.Timer

class SplashFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var timer: Timer = Timer()

    private val delay: Int = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        StartTimer()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    fun StartTimer(){
        val timer = object : CountDownTimer(1500,1000){
            override fun onTick(p0: Long) {

            }

            override fun onFinish() {
                (activity as MainActivity).showFragment(SignUpFragment.newInstance())
            }
        }.start()
    }


    companion object {

        @JvmStatic
        fun newInstance() =
            SplashFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}