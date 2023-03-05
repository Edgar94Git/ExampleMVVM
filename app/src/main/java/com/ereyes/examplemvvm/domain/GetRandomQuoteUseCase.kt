package com.ereyes.examplemvvm.domain

import com.ereyes.examplemvvm.data.model.QuoteModel
import com.ereyes.examplemvvm.data.model.QuoteProvider
import javax.inject.Inject

/****
 * Project: ExampleMVVM
 * From: com.ereyes.examplemvvm.domain
 * Created by Edgar Reyes Gonzalez on 3/5/2023 at 4:07 PM
 * All rights reserved 2023.
 ****/
class GetRandomQuoteUseCase @Inject constructor(private val quoteProvider: QuoteProvider) {
    operator fun invoke(): QuoteModel? {
        val quotes: List<QuoteModel> = quoteProvider.quotes
        if(quotes.isNotEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}