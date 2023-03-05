package com.ereyes.examplemvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.ereyes.examplemvvm.databinding.ActivityMainBinding
import com.ereyes.examplemvvm.model.QuoteModel
import com.ereyes.examplemvvm.viewModel.QuoteViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpObservers()
        setUpClickListener()
    }

    private fun setUpObservers(){
        quoteViewModel.getQuoteModel().observe(this){ quoteModel ->
            loadInformation(quoteModel)
        }
    }

    private fun setUpClickListener(){
        binding.viwContainer.setOnClickListener {
            quoteViewModel.random()
        }
    }

    private fun loadInformation(quoteModel: QuoteModel){
        binding.tvAuthor.text = quoteModel.author
        binding.tvQuote.text = quoteModel.quote
    }
}