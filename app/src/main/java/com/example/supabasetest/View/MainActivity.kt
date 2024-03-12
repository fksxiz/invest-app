package com.example.supabasetest.View

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.supabasetest.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        savedInstanceState?:showFragment(SplashFragment.newInstance())
    }

    fun showFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.Frame,fragment)
            if(fragment !is SplashFragment && fragment !is SignUpFragment) addToBackStack(null)
            commit()
        }
    }
}