package com.ereyes.examplemvvm.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ereyes.examplemvvm.domain.GetQuotesUseCase
import com.ereyes.examplemvvm.domain.GetRandomQuoteUseCase
import com.ereyes.examplemvvm.domain.model.Quote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/****
 * Project: ExampleMVVM
 * From: com.ereyes.examplemvvm.viewModel
 * Created by Edgar Reyes Gonzalez on 3/5/2023 at 1:49 PM
 * All rights reserved 2023.
 ****/
@HiltViewModel
class QuoteViewModel @Inject constructor(
    val getQuotesUseCase: GetQuotesUseCase,
    val getRandomQuoteUseCase: GetRandomQuoteUseCase
) : ViewModel() {

    private val quoteModel: MutableLiveData<Quote> = MutableLiveData<Quote>()
    fun getQuoteModel(): MutableLiveData<Quote> = quoteModel

    private val loaded: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    fun isLoaded(): MutableLiveData<Boolean> = loaded

    private val snackBarMsg: MutableLiveData<String> = MutableLiveData<String>()
    fun getSnackBarMsg(): MutableLiveData<String> = snackBarMsg

    fun randomQuote() {
        viewModelScope.launch{
            try {
                loaded.value = true
                val quote = getRandomQuoteUseCase()
                if(quote != null) {
                    quoteModel.value = quote!!
                }
            } catch (e: Exception) {
                snackBarMsg.value = e.message
            } finally {
                loaded.value = false
            }
        }
    }

    fun onCreate() {
        viewModelScope.launch {
            try {
                loaded.value = true
                val result: List<Quote>? = getQuotesUseCase()
                if (!result.isNullOrEmpty()) {
                    quoteModel.value = result[0]
                }
            } catch (e: Exception) {
                snackBarMsg.value = e.message
            } finally {
                loaded.value = false
            }
        }
    }
}