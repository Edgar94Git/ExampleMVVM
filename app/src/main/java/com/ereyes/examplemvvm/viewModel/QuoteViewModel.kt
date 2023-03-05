package com.ereyes.examplemvvm.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ereyes.examplemvvm.model.QuoteModel
import com.ereyes.examplemvvm.model.QuoteProvider

/****
 * Project: ExampleMVVM
 * From: com.ereyes.examplemvvm.viewModel
 * Created by Edgar Reyes Gonzalez on 3/5/2023 at 1:49 PM
 * All rights reserved 2023.
 ****/
class QuoteViewModel: ViewModel() {

    private val quoteModel: MutableLiveData<QuoteModel> = MutableLiveData<QuoteModel>()
    fun getQuoteModel(): MutableLiveData<QuoteModel> = quoteModel

    fun random(){
        val currentQuote: QuoteModel = QuoteProvider.random()
        quoteModel.value = currentQuote
    }
}