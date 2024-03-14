package com.example.supabasetest.View

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.supabasetest.Common.User
import com.example.supabasetest.Model.Supabase
import com.example.supabasetest.R
import com.example.supabasetest.ViewModel.BaseViewModel
import com.example.supabasetest.ViewModel.ListAdapter
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class HomeFragment : Fragment() {

    private val viewModel:BaseViewModel by viewModels()
    private lateinit var helloText:TextView
    private lateinit var newsListView:ListView
    private var user: User = User()

    private lateinit var adapter:ListAdapter

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
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
    
    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.apply {
            helloText = findViewById(R.id.WelcomeTextView)
            newsListView = findViewById(R.id.ScrollListView)
        }
        adapter = ListAdapter(requireContext())
        newsListView.adapter = adapter
        getNews()
        setText()
        viewModel.news.observe(viewLifecycleOwner){
            adapter.news=it
            adapter.notifyDataSetChanged()
        }
        viewModel.user.observe(viewLifecycleOwner){
            user=it
            helloText.setText("Welcome, ${user.name?:""}")
        }
        adapter.notifyDataSetChanged()
    }

    @SuppressLint("SetTextI18n")
    fun setText(){
        lifecycleScope.launch {

            viewModel.getUser(1){
                user=it
                helloText.setText("Welcome, ${user.name?:""}")
            }
        }
    }

    @SuppressLint("SetTextI18n")
    fun getNews(){
        lifecycleScope.launch {
            viewModel.getNews {
                adapter.news=it
                adapter.notifyDataSetChanged()
            }
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            HomeFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}