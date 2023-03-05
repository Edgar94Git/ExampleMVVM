package com.ereyes.examplemvvm.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ereyes.examplemvvm.data.model.QuoteModel
import com.ereyes.examplemvvm.domain.GetQuotesUseCase
import com.ereyes.examplemvvm.domain.GetRandomQuoteUseCase
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

    private val quoteModel: MutableLiveData<QuoteModel> = MutableLiveData<QuoteModel>()
    fun getQuoteModel(): MutableLiveData<QuoteModel> = quoteModel

    private val loaded: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    fun isLoaded(): MutableLiveData<Boolean> = loaded

    private val snackBarMsg: MutableLiveData<String> = MutableLiveData<String>()
    fun getSnackBarMsg(): MutableLiveData<String> = snackBarMsg

    fun randomQuote() {
        try {
            loaded.value = true
            val quote = getRandomQuoteUseCase()
            quote.let {
                quoteModel.value = it
            }
        } catch (e: Exception) {
            snackBarMsg.value = e.message
        } finally {
            loaded.value = false
        }
    }

    fun onCreate() {
        viewModelScope.launch {
            try {
                loaded.value = true
                val result: List<QuoteModel>? = getQuotesUseCase()
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