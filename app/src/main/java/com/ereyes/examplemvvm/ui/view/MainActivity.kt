package com.ereyes.examplemvvm.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.ereyes.examplemvvm.databinding.ActivityMainBinding
import com.ereyes.examplemvvm.domain.model.Quote
import com.ereyes.examplemvvm.ui.viewModel.QuoteViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.onCreate()
        setUpObservers()
        setUpClickListener()
    }

    private fun setUpObservers(){
        quoteViewModel.getQuoteModel().observe(this){ quoteModel ->
            loadInformation(quoteModel)
        }
        quoteViewModel.isLoaded().observe(this){ isLoaded ->
            binding.progressBarQuote.isVisible = isLoaded
        }
        quoteViewModel.getSnackBarMsg().observe(this){ msg ->
            Snackbar.make(binding.root, msg, Snackbar.LENGTH_LONG).show()
        }
    }

    private fun setUpClickListener(){
        binding.viwContainer.setOnClickListener {
            quoteViewModel.randomQuote()
        }
    }

    private fun loadInformation(quote: Quote){
        binding.tvAuthor.text = quote.author
        binding.tvQuote.text = quote.quote
    }
}